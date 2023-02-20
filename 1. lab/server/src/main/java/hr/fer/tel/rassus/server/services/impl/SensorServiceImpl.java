package hr.fer.tel.rassus.server.services.impl;

import hr.fer.tel.rassus.server.models.Sensor;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import hr.fer.tel.rassus.server.services.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {

    Logger logger = LoggerFactory.getLogger(SensorServiceImpl.class);
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    //TODO: fix this maybe return void
    @Override
    public Sensor registerSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor getClosestNeighbour(Long id) {
        List<Sensor> allSensors = sensorRepository.findAll();

        //If there is only one sensor it means there is no neighbour
        if(allSensors.size() == 1){
            return null;
        }

        Optional<Sensor> sensorOptional = sensorRepository.findById(id);
        if(sensorOptional.isEmpty()){
            //TODO: Sensor with given id doesn't exist
            return null;
        }

        Sensor mainSensor = sensorOptional.get();
        Sensor firstSensor = allSensors.get(0);                  // first sensor to which we compare our main sensor
        //TODO: only one registered sensor


        //check if first sensor from list is equal to given sensor, if yes, change it
        if (firstSensor.equals(mainSensor)) {
            firstSensor = allSensors.get(1);
        }
        // set minimal distance
        double minimalDistance = calculateDistance(mainSensor, firstSensor);
        Sensor closestSensor = firstSensor;

        //loop over sensors and check distance
        for (Sensor sensor : allSensors) {
            if (sensor.equals(mainSensor)) continue;

            double distance = calculateDistance(mainSensor, sensor);
            if (minimalDistance > distance) {
                minimalDistance = distance;
                closestSensor = sensor;
            }
        }

        logger.info("CLOSEST-SENSOR" + closestSensor);
        return closestSensor;
    }


    /**
     * Calculates distance between two sensors
     * @param sensor1
     * @param sensor2
     * @return distance
     */
    private double calculateDistance(Sensor sensor1, Sensor sensor2) {
        int R = 6371;
        double dlon = sensor2.getLongitude() - sensor1.getLongitude();
        double dlat = sensor2.getLatitude() - sensor1.getLatitude();

        double a = Math.sqrt(Math.sin(dlat / 2)) + Math.cos(sensor1.getLatitude()) * Math.cos(sensor2.getLatitude()) * Math.sqrt(Math.sin(dlon / 2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
