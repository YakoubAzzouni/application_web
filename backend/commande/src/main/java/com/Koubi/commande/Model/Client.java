package com.Koubi.commande.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @Column(name = "client_id", updatable = false, nullable = false, unique = true, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID client_id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private double plate_number;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Reservation> reservations;


    public Client() {
    }

    public Client(@JsonProperty("name") String name,
                  @JsonProperty("plate_number") double plate_number,
                  @JsonProperty("email") String email) {
        this.email = email;
        this.name = name;
        this.plate_number = plate_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public UUID getClient_id() {
        return client_id;
    }

    public double getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(double plate_number) {
        this.plate_number = plate_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
