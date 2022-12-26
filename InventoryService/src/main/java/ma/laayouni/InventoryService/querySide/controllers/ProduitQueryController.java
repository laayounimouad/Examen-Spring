package ma.laayouni.InventoryService.querySide.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.laayouni.InventoryService.querySide.entities.Produit;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.produit.GetAllProduitsQuery;
import queries.produit.GetProduitByIdQuery;

import java.util.List;


@RestController
@RequestMapping("/queries/produit")
@AllArgsConstructor
@Slf4j
public class ProduitQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allProduits")
    public List<Produit> ProduitsList() {
        List<Produit> response = queryGateway.query(new GetAllProduitsQuery(), ResponseTypes.multipleInstancesOf(Produit.class)).join();
        return response;
    }

    @GetMapping("/byId/{id}")
    public Produit ProduitById(@PathVariable String id){
        Produit response = queryGateway.query(new GetProduitByIdQuery(id), ResponseTypes.instanceOf(Produit.class)).join();
        return response;
    }
}
