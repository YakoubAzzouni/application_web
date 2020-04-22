package com.Koubi.parking.Service;

import com.Koubi.parking.Model.Parking;
import com.Koubi.parking.Model.Ville;
import com.Koubi.parking.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VilleService {
    private VilleRepository vr;
    // cons
    @Autowired
    public VilleService(VilleRepository vr) { this.vr = vr;}

    //******* get  *************
    public Ville getVilleById(UUID ville_id){ return vr.findById(ville_id).get(); }
    public Iterable<Ville> getAllVille(){ return vr.findAll();}
    public Iterable<Ville> findByCity(String city){
        return vr.findByCity(city);
    }
    public List<Parking> getParkingsForVille(UUID ville_id) {
        Ville v = vr.findById(ville_id).get();
        return v.getParkings();
    }

    //********  post *************
    public Ville insertVille(Ville ville){ return vr.save(ville); }

    //******** put *********
    public Ville updateVille(UUID ville_id, Ville ville){
        Ville tmp_ville = vr.findById(ville_id).get();
        // recup where id = then modifier l'objet recuperer
        tmp_ville.setCity(ville.getCity());
        tmp_ville.setCode(ville.getCode());
        return vr.save(tmp_ville);
    }

    //******** delete ******
    public Ville deleteVille(UUID ville_id){
        Ville tmp_ville = vr.findById(ville_id).get();
        vr.deleteById(ville_id); // delete happens here the other thigs to return it
        return tmp_ville;
    }


}
