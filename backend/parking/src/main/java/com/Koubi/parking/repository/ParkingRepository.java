package com.Koubi.parking.Repository;

import com.Koubi.parking.Model.Parking;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ParkingRepository extends CrudRepository<Parking, UUID> {

    Iterable<Parking> findByVilleCity(String city);
}
