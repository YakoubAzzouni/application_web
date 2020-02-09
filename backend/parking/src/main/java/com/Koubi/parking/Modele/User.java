package com.Koubi.parking.Modele;

import java.util.UUID;

public class User {
    private UUID user_id;
    private double car_plate_number;
    private String user_name;
    private String user_password;

    public User(double car_plate_number, String user_name, String user_password) {
        this.car_plate_number = car_plate_number;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public double getCar_plate_number() {
        return car_plate_number;
    }

    public void setCar_plate_number(double car_plate_number) {
        this.car_plate_number = car_plate_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
