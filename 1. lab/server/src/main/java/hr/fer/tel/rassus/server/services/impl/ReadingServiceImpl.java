package hr.fer.tel.rassus.server.services.impl;

import hr.fer.tel.rassus.server.models.Reading;
import hr.fer.tel.rassus.server.models.Sensor;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import hr.fer.tel.rassus.server.services.ReadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    ReadingRepository readingRepository;
    SensorRepository sensorRepository;
    Logger logger = LoggerFactory.getLogger(ReadingServiceImpl.class);


    @Autowired
    public ReadingServiceImpl(ReadingRepository readingRepository, SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }


    @Override
    public Reading saveReading(Reading reading) {
        Optional<Sensor> sensor = sensorRepository.findById(reading.getSensorId());

        if(sensor.isEmpty()){
            logger.info("SAVING READING: Sensor with given ID does not exist!");
            return null;
        }else{
            logger.info("SAVING READING: Reading saved!");
            return  readingRepository.save(reading);
        }
    }

    @Override
    public List<Reading> getSensorReadings(Long id) {
        return readingRepository.findSensorReadingsBySensorId(id);
    }
}
