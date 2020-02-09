package com.Koubi.parking.dao;

import com.Koubi.parking.Modele.Parking;

import java.util.List;
import java.util.UUID;

public interface ParkingDAO {
    int addParking(UUID parking_id, Parking park);
    int deleteParking(UUID parking_id);
    List<Parking> GetAllParking();
    void editParking(Parking park);
}
