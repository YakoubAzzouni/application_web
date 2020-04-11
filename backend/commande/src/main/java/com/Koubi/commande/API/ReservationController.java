package com.Koubi.commande.API;

import com.Koubi.commande.Model.Reservation;
import com.Koubi.commande.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("reservation") // besh n9olo win yaffichiha
@RestController
public class ReservationController {
    private final ReservationService rs;

    @Autowired
    public ReservationController(ReservationService rs) {
        this.rs = rs;
    }

    //******** get *********
    @GetMapping
    private Iterable<Reservation> getAllReservations(){
        return rs.getAllReservations();
    }

    //********* get *******
    @PostMapping
    private @ResponseBody
    Reservation insertReservation(@RequestBody Reservation reservation){
        return rs.insertReservation(reservation);
    }
}
