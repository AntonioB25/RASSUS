package hr.fer.tel.rassus.server.repositories;

import hr.fer.tel.rassus.server.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    //  TODO: dohvati sve senzore
    List<Sensor> findAll();
}
