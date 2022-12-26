package ma.laayouni.InventoryService.commandSide.aggregates;


import commands.category.CreateCategoryCommand;
import commands.category.UpdateCategoryCommand;
import enums.Etat;
import events.category.CategoryCreatedEvent;
import events.category.CategoryUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private String desc;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        AggregateLifecycle.apply(new CategoryCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getDesc()

        ));
    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event) {
        this.id = event.getId();
        this.nom= event.getNom();
        this.desc= event.getDesc();
    }

    @CommandHandler
    public void handle(UpdateCategoryCommand command) {
        AggregateLifecycle.apply(new CategoryUpdatedEvent(
                command.getId(),
                command.getNom(),
                command.getDesc()
        ));
    }

    @EventSourcingHandler
    public void on(CategoryUpdatedEvent event) {
        this.id = event.getId();
        this.nom= event.getNom();
        this.desc= event.getDesc();
    }
}
