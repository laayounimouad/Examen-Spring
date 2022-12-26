package ma.laayouni.InventoryService.querySide.repositories;

import ma.laayouni.InventoryService.querySide.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,String> {
}
