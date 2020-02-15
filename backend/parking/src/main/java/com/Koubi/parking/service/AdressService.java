package com.Koubi.parking.service;

import com.Koubi.parking.Modele.Adress;
import com.Koubi.parking.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdressService {
    //var
    private AdressRepository ar;
    // cons
    @Autowired
    public AdressService(AdressRepository ar) { this.ar = ar;}
    //methode
    public Adress getAdressById(UUID adress_id){ return ar.findById(adress_id).get(); }
}
