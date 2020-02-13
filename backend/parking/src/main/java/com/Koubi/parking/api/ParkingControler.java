package com.Koubi.parking.api;

import com.Koubi.parking.Modele.Parking;
import com.Koubi.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


// tjr ykounou
@CrossOrigin(origins = "http://localhost:4200") //n7ato ta3 angular
@RequestMapping("api/parking") // besh n9olo win yaffichiha
@RestController
public class ParkingControler {
    private final ParkingService parkingservice;

    @Autowired
    public ParkingControler(ParkingService parkingservice) {
        this.parkingservice = parkingservice;
    }


    @GetMapping
    private Iterable<Parking> getAllParking(){
        return parkingservice.GetAllParking();
    }

    @GetMapping("{parking_id}")
    private Parking getParkingById(@PathVariable("parking_id") UUID parking_id){
        return parkingservice.getParkingById(parking_id);
    }

    @PostMapping
    private @ResponseBody Parking insertParking(@RequestBody Parking park){
        return parkingservice.insertParking(park);
    }

    @DeleteMapping("{parking_id}")
    private @ResponseBody Parking deleteParking(@PathVariable("parking_id") UUID id){
        return parkingservice.deleteParking(id);
    }

    @PutMapping("{parking_id}")
    private @ResponseBody Parking updateParking(@PathVariable("parking_id") UUID parking_id,
                                                @RequestBody Parking park){

        return parkingservice.updateParking(parking_id, park);
    }
}
