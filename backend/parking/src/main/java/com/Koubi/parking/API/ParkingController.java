package com.Koubi.parking.API;

import com.Koubi.parking.Model.Parking;
import com.Koubi.parking.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("parking") // besh n9olo win yaffichiha
@RestController
public class ParkingController {
    private final ParkingService parkingservice;

    @Autowired
    public ParkingController(ParkingService parkingservice) {
        this.parkingservice = parkingservice;
    }


    @GetMapping
    private Iterable<Parking> getAllParking(){
        return parkingservice.GetAllParking();
    }

    @GetMapping("/city/{city}")
    private Iterable<Parking> findByVilleCity(@PathVariable("city") String city){
        return  parkingservice.findByVilleCity(city);
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
    private @ResponseBody Parking editParking(@PathVariable("parking_id") UUID parking_id,
                                              @RequestBody Parking park){

        return parkingservice.editParking(parking_id, park);
    }
}
