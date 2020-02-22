package com.Koubi.parking.api;


import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200") //n7ato ta3 angular
@RequestMapping("api") // besh n9olo win yaffichiha
@RestController
public class LoginControler {

    @GetMapping("isLogged")
    private @ResponseBody String isLogged(){
        return "congrats";
    }

    @GetMapping("isNotLogged")
    private @ResponseBody String isNotLogged(){
        return "boutarma";
    }
}
