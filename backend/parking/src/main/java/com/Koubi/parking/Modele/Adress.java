package com.Koubi.parking.Modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
//@Table(name = "adress")
public class Adress implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID adress_id;

    @Column
    @NotNull
    private String rue;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private int code;

    /*@OneToMany(mappedBy = "parking")
    private Set<Parking> parkings;*/


    public Adress(@JsonProperty("rue") String rue,
                  @JsonProperty("cuty") String city,
                  @JsonProperty("code") int code){
        this.rue = rue;
        this.city = city;
        this.code = code;
    }
    public Adress(){}

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UUID getAdress_id() {
        return adress_id;
    }
}
