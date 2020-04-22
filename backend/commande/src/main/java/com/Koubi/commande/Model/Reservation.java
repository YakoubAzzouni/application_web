package com.Koubi.commande.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
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
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date dateIn;

    @Column
    @NotNull
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date dateOut;

    @Column
    @NotNull
    private UUID parking_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    @JsonManagedReference // we have to add
    private Client client;


    public Reservation() {
    }

    public Reservation(@JsonProperty("date_in") Date dateIn,
                       @JsonProperty("date_out") Date dateOut,
                       @JsonProperty("parking_id") UUID parking_id,
                       @JsonProperty("client") Client client) {
        this.client = client;
        this.parking_id = parking_id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
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


    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
}
