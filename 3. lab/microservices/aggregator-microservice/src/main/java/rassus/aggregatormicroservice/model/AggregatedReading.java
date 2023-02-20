package rassus.aggregatormicroservice.model;

public class AggregatedReading {
    private Temperature temperature;
    private SensorReading sensorReading;

    public AggregatedReading(Temperature temperature, SensorReading sensorReading) {
        this.temperature = temperature;
        this.sensorReading = sensorReading;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public SensorReading getHumidity() {
        return sensorReading;
    }

    public void setHumidity(SensorReading sensorReading) {
        this.sensorReading = sensorReading;
    }

    @Override
    public String toString() {
        return "AggregatedReading{" +
                "temperature=" + temperature +
                ", humidity=" + sensorReading +
                '}';
    }
}
