package ma.laayouni.InventoryService.commandSide.controllers;

import commands.produit.CreateProduitCommand;
import commands.produit.UpdateProduitCommand;
import dtos.produit.CreateProduitRequestDTO;
import dtos.produit.UpdateProduitRequestDTO;
import enums.Etat;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/produit")
@AllArgsConstructor
public class ProduitCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProduit(@RequestBody CreateProduitRequestDTO request) {

        return commandGateway.send(new CreateProduitCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getQuantite()>0?Etat.DISPONIBLE:Etat.RUPTURE,//if qantity is 0 set state as RUPTURE if not set it as DISPONIBLE
                request.getPrix(),
                request.getQuantite(),
                request.getCategoryId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateProduit(@RequestBody UpdateProduitRequestDTO request) {
        return commandGateway.send(new UpdateProduitCommand(
                request.getId(),
                request.getNom(),
                request.getQuantite()>0?Etat.DISPONIBLE:Etat.RUPTURE,//if qantity is 0 set state as RUPTURE if not set it as DISPONIBLE
                request.getPrix(),
                request.getQuantite(),
                request.getCategoryId()

        ));
    }
}
