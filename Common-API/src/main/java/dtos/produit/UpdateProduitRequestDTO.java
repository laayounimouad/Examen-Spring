package dtos.produit;


import enums.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProduitRequestDTO {
    private String id;
    private String nom;
    private double prix;
    private int quantite;
    private String categoryId;
}
