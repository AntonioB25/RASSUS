package rassus.humiditymicroservice.service;

import rassus.humiditymicroservice.model.SensorReading;
public interface IHumidityService {
    SensorReading readHumidity();
}
