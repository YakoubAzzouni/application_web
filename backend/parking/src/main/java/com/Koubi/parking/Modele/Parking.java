package com.Koubi.parking.Modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public class Parking {

    private UUID parking_id;
    private String name;
    private double prix;

    public Parking(/*@JsonProperty("parking_id")*/ UUID parking_id,
                   @JsonProperty("name") String name,
                   @JsonProperty("prix") double prix) {

        this.parking_id = parking_id;
        this.name = name;
        this.prix = prix;
    }

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

    @Override
    public String toString() {
        return "Parking{" +
                "parking_id=" + parking_id +
                ", name='" + name + '\'' +
                ", prix=" + prix +
                '}';
    }

    public UUID getParking_id() {
        return parking_id;
    }
}
