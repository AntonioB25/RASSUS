package rassus.aggregatormicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rassus.aggregatormicroservice.api.Constants;
import rassus.aggregatormicroservice.model.AggregatedReading;
import rassus.aggregatormicroservice.model.SensorReading;
import rassus.aggregatormicroservice.model.Temperature;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregationServiceImpl implements IAggregationService{
    // private final String tempUrl = "http://localhost:8090/sensor/temperature";
    // private final String humaUrl = "http://localhost:8060/sensor/humidity";
    @LoadBalanced
    private final RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;

    @Autowired
    public AggregationServiceImpl(RestTemplateBuilder restTemplateBuilder, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplateBuilder.build();
        this.discoveryClient = discoveryClient;
    }

    @Override
    public List<SensorReading> getReadingInCelsius() {
        ServiceInstance humaService = discoveryClient.getInstances(Constants.HUMA_MS_ID).get(0);
        ServiceInstance tempService = discoveryClient.getInstances(Constants.TEMP_MS_ID).get(0);

        System.out.println("HUMA_S: " + humaService);
        System.out.println("TEMP_S: " + tempService);

        String humaUrl = humaService.getUri().toString() + Constants.HUMA_PATH;
        String tempUrl = tempService.getUri().toString() + Constants.TEMP_PATH;

        System.out.println("HUMA_URL" + humaUrl);
        System.out.println("TEMP_URL" + tempUrl);

        SensorReading humidity = this.restTemplate.getForObject(humaUrl, SensorReading.class);
        System.out.println("****************** HUMA:");
        System.out.println("*******************" +humidity);
        SensorReading temperature = this.restTemplate.getForObject(tempUrl, SensorReading.class);


        List<SensorReading> aggregated = new ArrayList<>();
        aggregated.add(temperature);
        aggregated.add(humidity);

        return aggregated;
    }

    @Override
    public List<SensorReading> getReadingInKelvin() {
        List<ServiceInstance> humaService = discoveryClient.getInstances(Constants.HUMA_MS_ID);
        List<ServiceInstance> tempService = discoveryClient.getInstances(Constants.TEMP_MS_ID);

        System.out.println("services: ");
        System.out.println(humaService);
        System.out.println(tempService);
        String humaUrl = humaService.get(0).getUri().toString() + Constants.HUMA_PATH;
        String tempUrl = tempService.get(0).getUri().toString() + Constants.TEMP_PATH;

        System.out.println("***" + humaUrl);
        SensorReading temperature = this.restTemplate.getForObject(tempUrl, SensorReading.class);
        SensorReading humidity = this.restTemplate.getForObject(humaUrl, SensorReading.class);

        System.out.println(temperature);
        assert temperature != null;
        temperature.setSensValue(temperature.getSensValue() + 275.15);
        temperature.setUnit("K");

        System.out.println(temperature);
        System.out.println(humidity);

        List<SensorReading> aggregated = new ArrayList<>();
        aggregated.add(temperature);
        aggregated.add(humidity);

        return aggregated;
    }
}
