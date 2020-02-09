package com.Koubi.parking.Modele;

import java.util.UUID;

public class Slots {
    private UUID slot_id;
    private int slot_number;

    public Slots(int slot_number) {
        this.slot_number = slot_number;
    }

    public int getSlot_number() {
        return slot_number;
    }

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
    }
}
