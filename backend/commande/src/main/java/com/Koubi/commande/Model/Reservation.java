package com.Koubi.commande.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity()
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column(name = "reservation_id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID reservation_id;

    @Column
    @NotNull
    private String date_in;

    @Column
    @NotNull
    private String date_out;

    @Column
    @NotNull
    private UUID parking_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    @JsonManagedReference // we have to add
    private Client client;


    public Reservation() {
    }

    public Reservation(@JsonProperty("date_in") String date_in,
                       @JsonProperty("date_out") String date_out,
                       @JsonProperty("parking_id") UUID parking_id,
                       @JsonProperty("client") Client client) {
        this.client = client;
        this.parking_id = parking_id;
        this.date_in = date_in;
        this.date_out = date_out;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public UUID getReservation_id() {
        return reservation_id;
    }

    public UUID getParking_id() {
        return parking_id;
    }

    public void setParking_id(UUID parking_id) {
        this.parking_id = parking_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
