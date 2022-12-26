package ma.laayouni.InventoryService.querySide.services;

import events.produit.ProduitCreatedEvent;
import events.produit.ProduitUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.laayouni.InventoryService.querySide.entities.Produit;
import ma.laayouni.InventoryService.querySide.repositories.CategoryRepository;
import ma.laayouni.InventoryService.querySide.repositories.ProduitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import queries.produit.GetAllProduitsQuery;
import queries.produit.GetProduitByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ProduitServiceHandler {
    private ProduitRepository produitRepository;
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(ProduitCreatedEvent event) {
        log.info("ProduitCreatedEvent received");
        Produit produit = new Produit();
        produit.setId(event.getId());
        produit.setPrix(event.getPrix());
        produit.setQuantite(event.getQuantite());
        produit.setCategory(categoryRepository.findById(event.getCategoryId()).get());
        produitRepository.save(produit);
    }

    @EventHandler
    public void on(ProduitUpdatedEvent event) {
        log.info("ProduitUpdatedEvent received");

        Produit produit = produitRepository.findById(event.getId()).get();
        produit.setPrix(event.getPrix());
        produit.setQuantite(event.getQuantite());
        produit.setCategory(categoryRepository.findById(event.getCategoryId()).get());
        produitRepository.save(produit);
    }
    @QueryHandler
    public List<Produit> on(GetAllProduitsQuery query){
        return produitRepository.findAll();
    }

    @QueryHandler
    public Produit on(GetProduitByIdQuery query){
        return produitRepository.findById(query.getId()).get();
    }

}
