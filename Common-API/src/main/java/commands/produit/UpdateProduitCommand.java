package commands.produit;


import commands.BaseCommand;
import enums.Etat;
import lombok.Getter;

public class UpdateProduitCommand extends BaseCommand<String> {
@Getter private String nom;
    @Getter private Etat etat;
    @Getter private double prix;
    @Getter private int quantite;
    @Getter private String categoryId;

    public UpdateProduitCommand(String id, String nom, Etat etat, double prix, int quantite, String categoryId) {
        super(id);
        this.nom = nom;
        this.etat = etat;
        this.prix = prix;
        this.quantite = quantite;
        this.categoryId = categoryId;
    }
}
