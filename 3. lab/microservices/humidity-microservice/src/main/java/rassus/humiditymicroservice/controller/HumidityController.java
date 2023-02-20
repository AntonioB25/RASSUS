package rassus.humiditymicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rassus.humiditymicroservice.model.SensorReading;
import rassus.humiditymicroservice.service.IHumidityService;

@RestController
@RequestMapping("/sensor")
public class HumidityController {
    IHumidityService humidityService;

    @Autowired
    public HumidityController(IHumidityService humidityService) {
        this.humidityService = humidityService;
    }

    @GetMapping("/humidity")
    public ResponseEntity<SensorReading> getTemperature(){
        SensorReading sensorReading = humidityService.readHumidity();

        return (sensorReading != null) ? ResponseEntity.ok(sensorReading) : ResponseEntity.noContent().build();
    }
    
}
