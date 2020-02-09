package com.Koubi.parking.service;

import com.Koubi.parking.Modele.Parking;
import com.Koubi.parking.dao.ParkingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service // ndirha f service
public class ParkingService {
    private final ParkingDAO parkingdao;

    @Autowired // avant chaque constructeu   // qualifer besh n9olo bali base de donner postgres on peut faire chaque objet la bse ta3o
    public ParkingService(@Qualifier("postgres") ParkingDAO parkingdao) {
        this.parkingdao = parkingdao;
    }

   public  List<Parking> GetAllParking() {
        return parkingdao.GetAllParking();
    }
}
