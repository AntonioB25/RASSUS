package hr.fer.tel.rassus.server.repositories;

import hr.fer.tel.rassus.server.models.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    //  TODO: dohvati sva očitanja za neki senzor
    List<Reading> findSensorReadingsBySensorId(Long sensorId);
}
