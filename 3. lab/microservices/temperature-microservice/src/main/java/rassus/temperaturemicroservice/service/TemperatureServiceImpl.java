package rassus.temperaturemicroservice.service;

import rassus.temperaturemicroservice.Util.ReadingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rassus.temperaturemicroservice.model.SensorReading;
import rassus.temperaturemicroservice.repository.TemperatureRepository;

@Service
public class TemperatureServiceImpl implements ITemperatureService{

    TemperatureRepository temperatureRepository;

    @Autowired
    public TemperatureServiceImpl(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public SensorReading readTemperature() {
        SensorReading currentSensorReading = null;

        try{
             currentSensorReading = ReadingUtil.getTemperatureReading();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        // save temperature to database
        if(currentSensorReading != null){
            temperatureRepository.save(currentSensorReading);
        }

        return currentSensorReading;
    }


}
