package rassus.aggregatormicroservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@org.springframework.context.annotation.Configuration
public class Configuration {

    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setValue(String unit) {
        this.unit = unit;
    }
}
