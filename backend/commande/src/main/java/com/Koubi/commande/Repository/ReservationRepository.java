package com.Koubi.commande.Repository;

import com.Koubi.commande.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.UUID;

public interface ReservationRepository extends CrudRepository<Reservation, UUID> {
    Iterable<Reservation> findAllByDateInBetween(Date dateIn, Date dateOut);
}
