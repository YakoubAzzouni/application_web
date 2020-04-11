package com.Koubi.parking.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ville")
public class Ville implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID ville_id;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private int code;

    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Parking> parkings;


    public Ville(
            @JsonProperty("city") String city,
            @JsonProperty("code") int code){
        this.city = city;
        this.code = code;
    }
    public Ville(){}

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

    public UUID getVille_id() {
        return ville_id;
    }

    public List<Parking> getParkings() {
        return parkings;
    }
}
