package com.Koubi.parking.repository;

import com.Koubi.parking.Modele.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReservationRepository extends CrudRepository<Reservation, UUID> {
}
