package ma.laayouni.CustomerService.commandSide.controllers;

import commands.client.CreateClientCommand;
import commands.client.UpdateClientCommand;
import dtos.client.CreateClientRequestDTO;
import dtos.client.UpdateClientRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/client")
@AllArgsConstructor
public class ClientCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createClient(@RequestBody CreateClientRequestDTO request) {
        return commandGateway.send(new CreateClientCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getAdresse(),
                request.getEmail(),
                request.getTele()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateClient(@RequestBody UpdateClientRequestDTO request) {
        return commandGateway.send(new UpdateClientCommand(
                request.getId(),
                request.getNom(),
                request.getAdresse(),
                request.getEmail(),
                request.getTele()
        ));
    }
}
