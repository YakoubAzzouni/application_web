package com.Koubi.parking.Modele;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID reservation_id;

    @Column
    @NotNull
    private Date date_in;

    @Column
    @NotNull
    private Date date_out;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    @JsonManagedReference // we have to add
    private User user;

    public Reservation(@JsonProperty("date_in") Date date_in,
                        @JsonProperty("date_out") Date date_out,
                       @JsonProperty("user") User user) {
        this.user = user;
        this.date_in = date_in;
        this.date_out = date_out;
    }

    public Reservation() {
    }


    public UUID getReservation_id() {
        return reservation_id;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
