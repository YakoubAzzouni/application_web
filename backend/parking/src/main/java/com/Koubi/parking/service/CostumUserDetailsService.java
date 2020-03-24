package com.Koubi.parking.service;

import com.Koubi.parking.Modele.CostumUserDetails;
import com.Koubi.parking.Modele.User;
import com.Koubi.parking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class CostumUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ur.save(user);
    }

    public User getUser(String username) {
        return ur.findByUsername(username).get();
    }

    public User deleteUser(UUID user_id){
        User deleted_user = ur.findById(user_id).get();
        ur.deleteById(user_id);
        return deleted_user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = ur.findByUsername(username);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("User_name not found"));
        return optionalUser
                .map(CostumUserDetails::new).get();
    }
    
}
