package ma.laayouni.InventoryService.querySide.repositories;

import ma.laayouni.InventoryService.querySide.entities.Category;
import ma.laayouni.InventoryService.querySide.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
