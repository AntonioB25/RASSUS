package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.models.Sensor;

import java.util.List;

public interface SensorService {

    /**
     * Get all registered sensors
     * @return list of sensors
     */
    List<Sensor> getAllSensors();

    /**
     * Register sensor
     * @param sensor
     * @return
     */
    Sensor registerSensor(Sensor sensor);
    Sensor getClosestNeighbour(Long id);
}
