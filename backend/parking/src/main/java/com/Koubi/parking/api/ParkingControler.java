package com.Koubi.parking.api;

import com.Koubi.parking.Modele.Parking;
import com.Koubi.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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


    @PostMapping
    private int addParking(@RequestBody Parking park)
    {
        return parkingservice.addParking(park);
    }

    @DeleteMapping("{parking_id}") // ndirou hadik besg nrecupiriw m url
    private int deleteParking(@PathVariable("parking_id") String park_id){
        UUID parking_id = UUID.fromString(park_id);
        return parkingservice.deleteParking(parking_id);
    }
}
