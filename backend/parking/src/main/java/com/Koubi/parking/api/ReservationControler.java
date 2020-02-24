package com.Koubi.parking.api;

import com.Koubi.parking.Modele.Reservation;
import com.Koubi.parking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200") //n7ato ta3 angular
@RequestMapping("api/reservation") // besh n9olo win yaffichiha
@RestController
public class ReservationControler {

    private final ReservationService reservation_service;

    @Autowired
    public ReservationControler(ReservationService reservation_service) {
        this.reservation_service = reservation_service;
    }

    @GetMapping
    private @ResponseBody Iterable<Reservation> getAllReservation(){ return reservation_service.getAllReservation();}
}
