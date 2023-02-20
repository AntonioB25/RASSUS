package rassus.aggregatormicroservice.service;

import rassus.aggregatormicroservice.model.AggregatedReading;
import rassus.aggregatormicroservice.model.SensorReading;

import java.util.List;

public interface IAggregationService {
    List<SensorReading> getReadingInCelsius();

    List<SensorReading> getReadingInKelvin();
}
