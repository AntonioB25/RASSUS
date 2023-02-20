package rassus.aggregatormicroservice.model;

import java.io.Serializable;

public class SensorReading implements Serializable {
    private String name;
    private Double sensValue;
    private String unit;

    public SensorReading(String name, Double sensValue, String unit) {
        this.name = name;
        this.sensValue = sensValue;
        this.unit = unit;
    }

    public SensorReading() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSensValue() {
        return sensValue;
    }

    public void setSensValue(Double sensValue) {
        this.sensValue = sensValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "name='" + name + '\'' +
                ", value=" + sensValue +
                ", unit='" + unit + '\'' +
                '}';
    }
}
