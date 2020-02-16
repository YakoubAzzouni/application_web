package com.Koubi.parking.service;

import com.Koubi.parking.Modele.Ville;
import com.Koubi.parking.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VilleService {
    //vvr
    private VilleRepository vr;
    // cons
    @Autowired
    public VilleService(VilleRepository vr) { this.vr = vr;}
    //methode
    public Ville getVilleById(UUID ville_id){ return vr.findById(ville_id).get(); }

    public Ville insertVille(Ville ville){ return vr.save(ville); }

    public Iterable<Ville> getAllVille(){ return vr.findAll();}

    public Ville updateVille(UUID ville_id, Ville ville){
        Ville tmp_ville = vr.findById(ville_id).get();
        // recup where id = then modifier l'objet recuperer
        tmp_ville.setCity(ville.getCity());
        tmp_ville.setCode(ville.getCode());
        return vr.save(tmp_ville);
    }

    public Ville deleteVille(UUID ville_id){
        Ville tmp_ville = vr.findById(ville_id).get();
        vr.deleteById(ville_id); // delete happens here the other thigs to return it
        return tmp_ville;
    }
}
