package events.produit;


import enums.Etat;
import events.BaseEvent;
import lombok.Getter;

public class ProduitUpdatedEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private Etat etat;
    @Getter private double prix;
    @Getter private int quantite;
    @Getter private String categoryId;

    public ProduitUpdatedEvent(String id, String nom, Etat etat, double prix, int quantite, String categoryId) {
        super(id);
        this.nom = nom;
        this.etat = etat;
        this.prix = prix;
        this.quantite = quantite;
        this.categoryId = categoryId;
    }
}
