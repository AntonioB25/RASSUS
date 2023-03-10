package rassus.aggregatormicroservice.controller;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rassus.aggregatormicroservice.AggregatorMicroserviceApplication;
import rassus.aggregatormicroservice.configuration.Configuration;
import rassus.aggregatormicroservice.model.AggregatedReading;
import rassus.aggregatormicroservice.model.SensorReading;
import rassus.aggregatormicroservice.service.IAggregationService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/aggregate")
public class AggregateController {

    IAggregationService aggregationService;
    Configuration configuration;
    @Value("${unit}")
    String unit;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    public AggregateController(IAggregationService aggregationService, Configuration configuration) {
        this.aggregationService = aggregationService;
        this.configuration = configuration;
    }

    @GetMapping("/readings")
    public List<SensorReading> getAggregatedReadings() {
        List<SensorReading> aggregatedReadings = new ArrayList<>();


        if (unit.equals("C")) {

            aggregatedReadings = aggregationService.getReadingInCelsius();
            return aggregatedReadings;

        } else if (unit.equals("K")) {
            aggregatedReadings = aggregationService.getReadingInKelvin();
            return aggregatedReadings;
        }

        return aggregatedReadings;
    }

    @GetMapping("/endpoint")
    public String retrieveLimits() {
        List<ServiceInstance> list = discoveryClient.getInstances("HUMIDITY-MICROSERVICE");

        System.out.println(list.get(0).getUri().toString());

        System.out.println("UNIT****: " + unit);
        return unit;
    }
}
