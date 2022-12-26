package ma.laayouni.InventoryService.commandSide.controllers;

import commands.category.CreateCategoryCommand;
import commands.category.UpdateCategoryCommand;
import dtos.category.CreateCategoryRequestDTO;
import dtos.category.UpdateCategoryRequestDTO;
import enums.Etat;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/category")
@AllArgsConstructor
public class CategoryCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCategory(@RequestBody CreateCategoryRequestDTO request) {

        return commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getDesc()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateCategory(@RequestBody UpdateCategoryRequestDTO request) {
        return commandGateway.send(new UpdateCategoryCommand(
                request.getId(),
                request.getNom(),
                request.getDesc()
        ));
    }
}
