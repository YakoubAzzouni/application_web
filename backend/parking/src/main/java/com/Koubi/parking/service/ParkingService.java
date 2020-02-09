package com.Koubi.parking.service;

import com.Koubi.parking.Modele.Parking;
import com.Koubi.parking.dao.ParkingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // ndirha f service
public class ParkingService {
    private final ParkingDAO parkingdao;

    @Autowired // avant chaque constructeu   // qualifer besh n9olo bali base de donner postgres on peut faire chaque objet la base ta3o
    public ParkingService(@Qualifier("postgres") ParkingDAO parkingdao) {
        this.parkingdao = parkingdao;
    }

    public  List<Parking> GetAllParking() {
        return parkingdao.GetAllParking();
    }

    public int addParking(Parking park) {
        UUID idTmp = null;
        UUID parking_id = Optional.ofNullable(idTmp)
                .orElse(UUID.randomUUID());

        return parkingdao.addParking(parking_id, park);
    }

    public int deleteParking(UUID parking_id){
        return parkingdao.deleteParking(parking_id);
    }
}
