package rassus.temperaturemicroservice.model;


import jakarta.persistence.*;

@Entity
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public void setSensValue(Double value) {
        this.sensValue = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
