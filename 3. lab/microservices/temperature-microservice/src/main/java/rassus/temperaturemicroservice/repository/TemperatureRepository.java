package rassus.temperaturemicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rassus.temperaturemicroservice.model.SensorReading;

public interface TemperatureRepository extends JpaRepository<SensorReading, Long> {

}
