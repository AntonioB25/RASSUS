package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.models.Reading;
import hr.fer.tel.rassus.server.models.Sensor;

import java.util.List;

public interface ReadingService {

    Reading saveReading(Reading reading);

    List<Reading> getSensorReadings (Long id);
}
