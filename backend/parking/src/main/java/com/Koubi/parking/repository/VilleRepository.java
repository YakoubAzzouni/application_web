package com.Koubi.parking.Repository;

import com.Koubi.parking.Model.Ville;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VilleRepository  extends CrudRepository<Ville, UUID> {
    Iterable<Ville> findByCity(String city);
}
