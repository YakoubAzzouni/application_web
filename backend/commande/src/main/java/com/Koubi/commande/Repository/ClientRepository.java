package com.Koubi.commande.Repository;

import com.Koubi.commande.Model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {
}
