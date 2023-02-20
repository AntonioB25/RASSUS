package rassus.humiditymicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rassus.humiditymicroservice.Util.ReadingUtil;
import rassus.humiditymicroservice.model.SensorReading;
import rassus.humiditymicroservice.repository.HumidityRepository;

@Service
public class HumidityServiceImpl implements IHumidityService {

    HumidityRepository humidityRepository;

    @Autowired
    public HumidityServiceImpl(HumidityRepository humidityRepository) {
        this.humidityRepository = humidityRepository;
    }


    @Override
    public SensorReading readHumidity() {
        SensorReading currentSensorReading = null;

        try {
            currentSensorReading = ReadingUtil.getHumidityReading();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // save temperature to database
        if (currentSensorReading != null) {
            humidityRepository.save(currentSensorReading);
        }

        return currentSensorReading;
    }


}
