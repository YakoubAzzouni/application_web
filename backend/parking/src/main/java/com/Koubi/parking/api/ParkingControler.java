package com.Koubi.parking.api;

import com.Koubi.parking.Modele.Parking;
import com.Koubi.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// tjr ykounou
@RequestMapping("api/parking") // besh n9olo win yaffichiha
@RestController
public class ParkingControler {
    private final ParkingService parkingservice;

    @Autowired
    public ParkingControler(ParkingService parkingservice) {
        this.parkingservice = parkingservice;
    }


    @GetMapping
    private List<Parking> getAllParking(){
        return parkingservice.GetAllParking();
    }

}
