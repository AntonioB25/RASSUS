package rassus.temperaturemicroservice.service;

import rassus.temperaturemicroservice.model.SensorReading;

public interface ITemperatureService {

    SensorReading readTemperature();

}
