package com.Koubi.parking.API;

import com.Koubi.parking.Model.Parking;
import com.Koubi.parking.Model.Ville;
import com.Koubi.parking.Service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequestMapping("ville") // besh n9olo win yaffichiha
@RestController
public class VilleController {
    private final VilleService ville_service;

    @Autowired
    public VilleController(VilleService vs) {this.ville_service = vs; }

                        ///************** get ********************//
    @GetMapping("{Ville_id}")
    private @ResponseBody
    Ville getVilleById(@PathVariable("Ville_id") UUID Ville_id){
        return ville_service.getVilleById(Ville_id);
    }

    @GetMapping("/city/{city}")
    private @ResponseBody Iterable<Ville> findByCity(@PathVariable("city") String city){
        return ville_service.findByCity(city);
    }

    @GetMapping("{ville_id}/parkings")
    private @ResponseBody
    List<Parking> getParkingsForVille(@PathVariable("ville_id") UUID ville_id) { return ville_service.getParkingsForVille(ville_id);}

    @GetMapping
    private @ResponseBody Iterable<Ville> getAllVille(){
        return ville_service.getAllVille();
    }

                        ///************** post ********************//

    @PostMapping
    private @ResponseBody Ville insertVille(@RequestBody Ville ad){
        return ville_service.insertVille(ad);
    }


                         ///************** delete ********************//

    @DeleteMapping("{Ville_id}")
    private @ResponseBody Ville deleteVille(@PathVariable("Ville_id") UUID Ville_id){
        return ville_service.deleteVille(Ville_id);
    }

                        ///************** Put ********************//

    @PutMapping("{Ville_id}")
    private @ResponseBody Ville updateVille(@PathVariable("Ville_id") UUID Ville_id,
                                            @RequestBody Ville ad){
        return ville_service.updateVille(Ville_id, ad);
    }
}
