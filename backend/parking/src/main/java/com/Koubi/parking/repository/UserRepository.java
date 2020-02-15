package com.Koubi.parking.repository;

import com.Koubi.parking.Modele.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
