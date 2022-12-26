package ma.laayouni.InventoryService.querySide.services;

import events.category.CategoryCreatedEvent;
import events.category.CategoryUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.laayouni.InventoryService.querySide.entities.Category;
import ma.laayouni.InventoryService.querySide.repositories.CategoryRepository;
import ma.laayouni.InventoryService.querySide.repositories.CategoryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import queries.category.GetAllCategoriesQuery;
import queries.category.GetCategoryByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CategoryServiceHandler {
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(CategoryCreatedEvent event) {
        log.info("CategoryCreatedEvent received");
        Category category = new Category();
        category.setCategory_id(event.getId());
        category.setDesc(event.getDesc());
        category.setNom(event.getNom());
        categoryRepository.save(category);
    }

    @EventHandler
    public void on(CategoryUpdatedEvent event) {
        log.info("CategoryUpdatedEvent received");

        Category category = categoryRepository.findById(event.getId()).get();
        category.setDesc(event.getDesc());
        category.setNom(event.getNom());
        categoryRepository.save(category);
    }
    @QueryHandler
    public List<Category> on(GetAllCategoriesQuery query){
        return categoryRepository.findAll();
    }

    @QueryHandler
    public Category on(GetCategoryByIdQuery query){
        return categoryRepository.findById(query.getId()).get();
    }

}
