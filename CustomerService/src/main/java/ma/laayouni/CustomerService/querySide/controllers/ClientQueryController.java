package ma.laayouni.CustomerService.querySide.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.laayouni.CustomerService.querySide.entities.Client;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.client.GetAllClientsQuery;
import queries.client.GetClientByIdQuery;

import java.util.List;


@RestController
@RequestMapping("/queries/client")
@AllArgsConstructor
@Slf4j
public class ClientQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allClients")
    public List<Client> ClientsList() {
        List<Client> response = queryGateway.query(new GetAllClientsQuery(), ResponseTypes.multipleInstancesOf(Client.class)).join();
        return response;
    }

    @GetMapping("/byId/{id}")
    public Client ClientByIdList(@PathVariable String id){
        Client response = queryGateway.query(new GetClientByIdQuery(id), ResponseTypes.instanceOf(Client.class)).join();
        return response;
    }
}
