package com.Koubi.parking.repository;

import com.Koubi.parking.Modele.Ville;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VilleRepository extends CrudRepository<Ville, UUID> {
}
