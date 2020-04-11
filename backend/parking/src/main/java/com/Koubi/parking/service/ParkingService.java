package com.Koubi.parking.Service;

import com.Koubi.parking.Model.Parking;
import com.Koubi.parking.Repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository pr;
    // n3ayto l repository
    //get all parkings
    public Iterable<Parking> GetAllParking(){
        return pr.findAll();
    }

    public Iterable<Parking> findByVilleCity(String city) { return pr.findByVilleCity(city);}

    // get parking by id
    public Parking getParkingById(UUID parking_id){
        return pr.findById(parking_id).get();
    }


    //insert into parking
    public Parking insertParking(Parking park){
        return  pr.save(park); // we have to do
    }

    //delete parking
    public Parking deleteParking(UUID parking_id){
        Parking parking = pr.findById(parking_id).get();
        pr.deleteById(parking_id);
        return parking;
    }

    // update parking by id
    public Parking editParking(UUID id, Parking park){
        Parking p = pr.findById(id).get();
        p.setAdress(park.getAdress());
        p.setNb_place(park.getNb_place());
        p.setName(park.getName());
        p.setPrice(park.getPrice());
        p.setVille(park.getVille());
        return pr.save(p) ;
    }
}
