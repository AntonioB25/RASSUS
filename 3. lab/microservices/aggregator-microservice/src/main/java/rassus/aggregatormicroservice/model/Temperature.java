package rassus.aggregatormicroservice.model;


import java.io.Serializable;

public class Temperature implements Serializable {
    private String name;
    private Double tempValue;
    private String unit;

    public Temperature(String name, Double tempValue, String unit) {
        this.name = name;
        this.tempValue = tempValue;
        this.unit = unit;
    }

    public Temperature() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTempValue() {
        return tempValue;
    }

    public void setTempValue(Double value) {
        this.tempValue = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "name='" + name + '\'' +
                ", tempValue=" + tempValue +
                ", unit='" + unit + '\'' +
                '}';
    }
}
