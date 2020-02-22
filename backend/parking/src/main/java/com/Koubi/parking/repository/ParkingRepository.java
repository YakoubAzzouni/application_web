package com.Koubi.parking.repository;

import com.Koubi.parking.Modele.Parking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ParkingRepository extends CrudRepository<Parking, UUID> {
}
