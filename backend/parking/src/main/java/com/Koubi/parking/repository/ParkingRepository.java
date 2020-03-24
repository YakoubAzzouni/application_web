package com.Koubi.parking.repository;

import com.Koubi.parking.Modele.Parking;
import com.Koubi.parking.Modele.Ville;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.UUID;

public interface ParkingRepository extends CrudRepository<Parking, UUID> {

    Iterable<Parking> findByVilleCity(String city);
}
