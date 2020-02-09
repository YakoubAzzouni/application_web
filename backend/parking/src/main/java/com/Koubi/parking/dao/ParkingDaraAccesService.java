package com.Koubi.parking.dao;

import com.Koubi.parking.Modele.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres") // avant la classe
public class ParkingDaraAccesService implements ParkingDAO {

    private final JdbcTemplate jdbcTemplate;  //always add

    @Autowired // have to do
    public ParkingDaraAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addParking(Parking park) {

    }

    @Override
    public void deleteParking(Parking park) {

    }

    @Override
    public List<Parking> GetAllParking() {
        final String sql = "select parking_id, name, prix from parking "; // requette

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID parking_id = UUID.fromString(resultSet.getString("parking_id"));
            String name = resultSet.getString("name");
            double prix = Double.parseDouble(resultSet.getString("prix"));
            return new Parking(parking_id, name, prix );
        });
    }

    @Override
    public void editParking(Parking park) {

    }
}
