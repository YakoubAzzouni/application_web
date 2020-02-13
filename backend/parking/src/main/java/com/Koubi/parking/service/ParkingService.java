package com.Koubi.parking.service;

import com.Koubi.parking.Modele.Parking;

import com.Koubi.parking.repository.ParkingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service // ndirha f service
public class ParkingService {

    @Autowired
    private ParkingRepository pr;
    // n3ayto l repository
    //get all parkings
    public Iterable<Parking> GetAllParking(){
        return pr.findAll();
    }

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
    public Parking updateParking(UUID id, Parking park){
        Parking p = pr.findById(id).get();
        p.setName(park.getName());
        p.setPrix(park.getPrix());
        return pr.save(p) ;
    }


}
