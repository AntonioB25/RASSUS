package rassus.humiditymicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rassus.humiditymicroservice.model.SensorReading;

public interface HumidityRepository extends JpaRepository<SensorReading, Long> {

}
