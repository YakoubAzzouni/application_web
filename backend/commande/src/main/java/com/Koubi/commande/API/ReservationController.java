package com.Koubi.commande.API;

import com.Koubi.commande.Model.Reservation;
import com.Koubi.commande.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @GetMapping("/get")
    private @ResponseBody
    Iterable<Reservation> getByDate_in(@RequestParam (required = true) @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateIn,
                                       @RequestParam (required = true) @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOut){
        return  rs.findByDateInBetween(dateIn, dateOut);
    }

    //********* get *******
    @PostMapping
    private @ResponseBody
    Reservation insertReservation(@RequestBody Reservation reservation){
        return rs.insertReservation(reservation);
    }
}
