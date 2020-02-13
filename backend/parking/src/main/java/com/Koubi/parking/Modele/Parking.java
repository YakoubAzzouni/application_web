package com.Koubi.parking.Modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Parking implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID parking_id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private double prix;

    public Parking(@JsonProperty("name") String name,
                   @JsonProperty("prix") double prix) {
        this.name = name;
        this.prix = prix;
    }

    public Parking() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public UUID getParking_id() {
        return parking_id;
    }
}
