package ma.laayouni.InventoryService.querySide.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    private String id;
    private String nom;
    private double prix;
    private int quantite;
    @ManyToOne
    private Category category;
}
