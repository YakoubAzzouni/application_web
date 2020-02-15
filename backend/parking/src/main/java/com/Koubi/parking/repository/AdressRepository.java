package com.Koubi.parking.repository;

import com.Koubi.parking.Modele.Adress;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AdressRepository extends CrudRepository<Adress, UUID> {
}
