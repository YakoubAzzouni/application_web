package com.Koubi.parking.api;

import com.Koubi.parking.Modele.User;
import com.Koubi.parking.service.CostumUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/user") // besh n9olo win yaffichiha
@RestController
public class UserControler {
    private CostumUserDetailsService us;

    @Autowired
    public UserControler(CostumUserDetailsService us) {this.us = us;}

    @PostMapping
    private @ResponseBody User creatUser(@RequestBody User u){
        return us.createUser(u);
    }

    @GetMapping
    private @ResponseBody String findByUser_name(Authentication authentication){ // authe.. njibouha m security
        try{
            String user_name = authentication.getName();
            User user = us.getUser(user_name);
            return "{" +
                    "\"status\": \"LOGGED\"," +
                    "\"username\": \"" + user.getUsername() + "\"," +
                    "\"email\": \"" + user.getEmail() + "\"," +
                    "\"role\": \"" + user.getRole() + "\"," +
                    "\"firstname\": \"" + user.getFirst_name() + "\"," +
                    "\"lastname\": \"" + user.getLast_name() + "\"," +
                    "\"plate_number\": \"" + user.getPlate_number() + "\"" +
                    "}";
        } catch (NullPointerException err){
            return "{" +
                    "\"status\": \"ERROR\"" +
                    "}";
        }
    }
}
