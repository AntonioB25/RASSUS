package hr.fer.tel.rassus.server.controllers;

import hr.fer.tel.rassus.server.models.Sensor;
import hr.fer.tel.rassus.server.services.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sensor")
public class SensorsController {

    private Logger logger = LoggerFactory.getLogger(SensorsController.class);
    private SensorService sensorService;


    @Autowired
    public SensorsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> sensorRegistration(@RequestBody Sensor sensor) {
        logger.info("REGISTRATION: " + sensor);
        Sensor registeredSensor = sensorService.registerSensor(sensor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(registeredSensor.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/allSensors")
    public List<Sensor> getAllRegisteredSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("{id}/closestNeighbour")
    public ResponseEntity<Sensor> getClosestNeighbour(@PathVariable("id") Long id) {

        logger.info("Request for closest neighbour with ID: " + id);
        Sensor closestNeighbour = sensorService.getClosestNeighbour(id);
        return (closestNeighbour != null) ? ResponseEntity.ok(closestNeighbour) : ResponseEntity.noContent().build();
    }
}
