package rassus.temperaturemicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rassus.temperaturemicroservice.model.SensorReading;
import rassus.temperaturemicroservice.service.ITemperatureService;

@RestController
@RequestMapping("/sensor")
public class TemperatureController {
    ITemperatureService temperatureService;

    @Autowired
    public TemperatureController(ITemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/temperature")
    public ResponseEntity<SensorReading> getTemperature(){
        SensorReading temp = temperatureService.readTemperature();
        return (temp != null) ? ResponseEntity.ok(temp) : ResponseEntity.noContent().build();
    }
    
}
