package ma.laayouni.CustomerService.querySide.services;

import events.client.ClientCreatedEvent;
import events.client.ClientUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.laayouni.CustomerService.querySide.entities.Client;
import ma.laayouni.CustomerService.querySide.repositories.ClientRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import queries.client.GetAllClientsQuery;
import queries.client.GetClientByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ClientServiceHandler {
    private ClientRepository clientRepository;

    @EventHandler
    public void on(ClientCreatedEvent event) {
        log.info("ClientCreatedEvent received");
        Client client = new Client();
        client.setId(event.getId());
        client.setAdresse(event.getAdresse());
        client.setEmail(event.getEmail());
        client.setNom(event.getNom());
        client.setTele(event.getTele());
        clientRepository.save(client);
    }

    @EventHandler
    public void on(ClientUpdatedEvent event) {
        log.info("ClientUpdatedEvent received");

        Client client = clientRepository.findById(event.getId()).get();
        client.setAdresse(event.getAdresse());
        client.setEmail(event.getEmail());
        client.setNom(event.getNom());
        client.setTele(event.getTele());
        clientRepository.save(client);
    }
    @QueryHandler
    public List<Client> on(GetAllClientsQuery query){
        return clientRepository.findAll();
    }

    @QueryHandler
    public Client on(GetClientByIdQuery query){
        return clientRepository.findById(query.getId()).get();
    }

}
