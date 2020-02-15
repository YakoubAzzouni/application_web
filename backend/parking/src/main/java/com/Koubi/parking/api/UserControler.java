package com.Koubi.parking.api;

import com.Koubi.parking.Modele.User;
import com.Koubi.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200") //n7ato ta3 angular
@RequestMapping("api/user") // besh n9olo win yaffichiha
@RestController
public class UserControler {
    private UserService us;

    @Autowired
    public UserControler(UserService us) {this.us = us;}

    @GetMapping
    private Iterable<User> getAllUsers(){ return us.getAllUsers();}

    @PostMapping
    private @ResponseBody User insertUser(@RequestBody  User u){return us.insertUser(u);}
}
