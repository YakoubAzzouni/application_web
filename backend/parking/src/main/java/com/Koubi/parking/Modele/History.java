package com.Koubi.parking.Modele;

import java.util.Date;
import java.util.UUID;

public class History {
    private UUID parking_slot_id;
    private UUID user_id;
    private Date date_in;
    private double durée;

    public History(UUID parking_slot_id, UUID user_id, Date date_in, double durée) {
        this.parking_slot_id = parking_slot_id;
        this.user_id = user_id;
        this.date_in = date_in;
        this.durée = durée;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public double getDurée() {
        return durée;
    }

    public void setDurée(double durée) {
        this.durée = durée;
    }
}
