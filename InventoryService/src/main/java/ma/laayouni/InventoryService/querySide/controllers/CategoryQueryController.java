package ma.laayouni.InventoryService.querySide.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.laayouni.InventoryService.querySide.entities.Category;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.category.GetAllCategoriesQuery;
import queries.category.GetCategoryByIdQuery;

import java.util.List;


@RestController
@RequestMapping("/queries/category")
@AllArgsConstructor
@Slf4j
public class CategoryQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allCategorys")
    public List<Category> CategorysList() {
        List<Category> response = queryGateway.query(new GetAllCategoriesQuery(), ResponseTypes.multipleInstancesOf(Category.class)).join();
        return response;
    }

    @GetMapping("/byId/{id}")
    public Category CategoryById(@PathVariable String id){
        Category response = queryGateway.query(new GetCategoryByIdQuery(id), ResponseTypes.instanceOf(Category.class)).join();
        return response;
    }
}
