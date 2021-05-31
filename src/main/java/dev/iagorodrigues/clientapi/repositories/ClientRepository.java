package dev.iagorodrigues.clientapi.repositories;

import dev.iagorodrigues.clientapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
