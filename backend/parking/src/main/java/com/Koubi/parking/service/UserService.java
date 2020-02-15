package com.Koubi.parking.service;

import com.Koubi.parking.Modele.User;
import com.Koubi.parking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;
     //get users
    public Iterable<User> getAllUsers(){ return ur.findAll();}
    // add user
    public User insertUser(User user){ return ur.save(user);}
}