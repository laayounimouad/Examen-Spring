package ma.laayouni.InventoryService.commandSide.aggregates;



import commands.produit.CreateProduitCommand;
import commands.produit.UpdateProduitCommand;
import enums.Etat;

import events.produit.ProduitCreatedEvent;
import events.produit.ProduitUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProduitAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private double prix;
    private int quantite;
    private String categoryId;
    private Etat etat;

    public ProduitAggregate() {
    }

    @CommandHandler
    public ProduitAggregate(CreateProduitCommand command) {
        AggregateLifecycle.apply(new ProduitCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getEtat(),
                command.getPrix(),
                command.getQuantite(),
                command.getCategoryId()

        ));
    }

    @EventSourcingHandler
    public void on(ProduitCreatedEvent event) {
        this.id = event.getId();
        this.categoryId=event.getCategoryId();
        this.etat=event.getEtat();
        this.nom= event.getNom();
        this.prix= event.getPrix();
        this.quantite= event.getQuantite();
    }

    @CommandHandler
    public void handle(UpdateProduitCommand command) {
        AggregateLifecycle.apply(new ProduitUpdatedEvent(
                command.getId(),
                command.getNom(),
                command.getEtat(),
                command.getPrix(),
                command.getQuantite(),
                command.getCategoryId()
        ));
    }

    @EventSourcingHandler
    public void on(ProduitUpdatedEvent event) {
        this.id = event.getId();
        this.categoryId=event.getCategoryId();
        this.etat=event.getEtat();
        this.nom= event.getNom();
        this.prix= event.getPrix();
        this.quantite= event.getQuantite();
    }
}
