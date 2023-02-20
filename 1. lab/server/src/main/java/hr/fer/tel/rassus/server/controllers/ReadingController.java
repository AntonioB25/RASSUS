package hr.fer.tel.rassus.server.controllers;


import hr.fer.tel.rassus.server.models.Reading;
import hr.fer.tel.rassus.server.services.ReadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sensor")
public class ReadingController {

    ReadingService readingService;
    Logger logger = LoggerFactory.getLogger(ReadingController.class);

    @Autowired
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    // TODO 4.3  Spremanje očitanja pojedinog senzora

    @PostMapping("/{id}/reading")
    public ResponseEntity<String> saveReading(@PathVariable("id") Long id, @RequestBody Reading reading) {
        reading.setSensorId(id); //set id of sensor
        logger.info("READING: " + reading);
        Reading savedReading = readingService.saveReading(reading);
        if (savedReading != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedReading.getId()).toUri();
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // TODO 4.5  Popis očitanja pojedinog senzora

    @GetMapping("/{id}/allReadings")
    public List<Reading> getAllReadingsOfSensor(@PathVariable("id") Long id) {
        logger.info("READING: Request made! with id = " + id);
        List<Reading> readings = readingService.getSensorReadings(id);
        logger.info(readings.toString());
        return readings;
    }


}