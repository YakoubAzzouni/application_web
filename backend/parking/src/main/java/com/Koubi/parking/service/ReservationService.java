package com.Koubi.parking.service;

import com.Koubi.parking.Modele.Reservation;
import com.Koubi.parking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService  {

    @Autowired //injetion des depandances
    private ReservationRepository rr;

    public Iterable<Reservation> getAllReservation(){ return rr.findAll();}

}

