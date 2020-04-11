package com.Koubi.parking.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity()
@Table(name = "parking")
public class Parking implements Serializable {

    @Id
    @Column(name = "parking_id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
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
    private String adress;

    @Column
    @NotNull
    private int nb_place;

    @Column
    @NotNull
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="ville_id", nullable = false)
    @JsonManagedReference // we have to add
    private Ville ville;

    public Parking(@JsonProperty("name") String name,
                   @JsonProperty("price") double price,
                   @JsonProperty("adress") String adress,
                   @JsonProperty("nb_place") int nb_place,
                   @JsonProperty("ville") Ville ville) {
        this.adress = adress;
        this.nb_place = nb_place;
        this.ville = ville;
        this.name = name;
        this.price = price;
    }

    public Parking() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public UUID getParking_id() {
        return parking_id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Ville getVille() {
        return ville;
    }


}
