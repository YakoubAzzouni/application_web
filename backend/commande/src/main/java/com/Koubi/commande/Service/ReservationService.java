package com.Koubi.commande.Service;

import com.Koubi.commande.Model.Reservation;
import com.Koubi.commande.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private final ReservationRepository rr;

    public ReservationService(ReservationRepository rr) {
        this.rr = rr;
    }

    public Iterable<Reservation> getAllReservations(){
        return rr.findAll();
    }

    public Reservation insertReservation(Reservation reservation){
        return rr.save(reservation);
    }
}
