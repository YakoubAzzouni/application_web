package com.Koubi.parking.api;

import com.Koubi.parking.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") //n7ato ta3 angular
@RequestMapping("api/adress") // besh n9olo win yaffichiha
@RestController
public class AdressControler {
    private final AdressService as;

    @Autowired
    public AdressControler(AdressService as) {this.as = as; }
}
