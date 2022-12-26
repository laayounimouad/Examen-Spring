package queries.produit;

import lombok.Getter;

public class GetProduitByIdQuery {
    @Getter private String id;

    public GetProduitByIdQuery(String id) {
        this.id = id;
    }
}
