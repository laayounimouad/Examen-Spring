package ma.laayouni.CustomerService.commandSide.aggregates;

import commands.client.CreateClientCommand;
import commands.client.UpdateClientCommand;

import events.client.ClientCreatedEvent;
import events.client.ClientUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class ClientAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private String adresse;
    private String email;
    private String tele;

    public ClientAggregate() {
    }

    @CommandHandler
    public ClientAggregate(CreateClientCommand command) {
        AggregateLifecycle.apply(new ClientCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getAdresse(),
                command.getEmail(),
                command.getTele()
        ));
    }

    @EventSourcingHandler
    public void on(ClientCreatedEvent event) {
        this.id = event.getId();
       this.adresse= event.getAdresse();
       this.email= event.getEmail();
       this.nom= event.getNom();
       this.tele= event.getTele();
    }

    @CommandHandler
    public void handle(UpdateClientCommand command) {
        AggregateLifecycle.apply(new ClientUpdatedEvent(
                command.getId(),
                command.getNom(),
                command.getAdresse(),
                command.getEmail(),
                command.getTele()
        ));
    }

    @EventSourcingHandler
    public void on(ClientUpdatedEvent event) {
        this.id = event.getId();
        this.adresse= event.getAdresse();
        this.email= event.getEmail();
        this.nom= event.getNom();
        this.tele= event.getTele();
    }
}
