package com.Koubi.parking.API;

import com.Koubi.parking.Model.Ville;
import com.Koubi.parking.Service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("ville") // besh n9olo win yaffichiha
@RestController
public class VilleController {
    private final VilleService ville_service;

    @Autowired
    public VilleController(VilleService vs) {this.ville_service = vs; }

    @GetMapping("{Ville_id}")
    private @ResponseBody
    Ville getVilleById(@PathVariable("Ville_id") UUID Ville_id){
        return ville_service.getVilleById(Ville_id);
    }

    @GetMapping("/city/{city}")
    private @ResponseBody Iterable<Ville> findByCity(@PathVariable("city") String city){
        return ville_service.findByCity(city);
    }

    @GetMapping
    private @ResponseBody Iterable<Ville> getAllVille(){
        return ville_service.getAllVille();
    }

    @PostMapping
    private @ResponseBody Ville insertVille(@RequestBody Ville ad){
        return ville_service.insertVille(ad);
    }

    @DeleteMapping("{Ville_id}")
    private @ResponseBody Ville deleteVille(@PathVariable("Ville_id") UUID Ville_id){
        return ville_service.deleteVille(Ville_id);
    }

    @PutMapping("{Ville_id}")
    private @ResponseBody Ville updateVille(@PathVariable("Ville_id") UUID Ville_id,
                                            @RequestBody Ville ad){
        return ville_service.updateVille(Ville_id, ad);
    }
}
