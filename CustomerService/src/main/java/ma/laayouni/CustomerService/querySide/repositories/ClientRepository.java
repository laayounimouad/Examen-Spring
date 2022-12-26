package ma.laayouni.CustomerService.querySide.repositories;

import ma.laayouni.CustomerService.querySide.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
