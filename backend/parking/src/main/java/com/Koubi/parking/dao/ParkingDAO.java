package com.Koubi.parking.dao;

import com.Koubi.parking.Modele.Parking;

import java.util.List;

public interface ParkingDAO {
    void addParking( Parking park);
    void deleteParking(Parking park);
    List<Parking> GetAllParking();
    void editParking(Parking park);
}
