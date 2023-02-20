package rassus.temperaturemicroservice.model;


import com.opencsv.bean.CsvBindByName;

public class CompleteReading {


    @CsvBindByName
    private Double temperature = null;
    @CsvBindByName
    private Double pressure = null;
    @CsvBindByName
    private Double humidity = null;
    @CsvBindByName
    private Double co = null;
    @CsvBindByName
    private Double so2 = null;
    @CsvBindByName
    private Double no2 = null;

    public CompleteReading() {
    }

    public CompleteReading(Double temperature, Double pressure, Double humidity, Double co, Double so2, Double no2) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.co = co;
        this.so2 = so2;
        this.no2 = no2;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    @Override
    public String toString() {
        return "SensorReading:\n" +
                "temperature=" + temperature +
                "\npressure=" + pressure +
                "\nhumidity=" + humidity +
                "\nco=" + co +
                "\nso2=" + so2 +
                "\nno2=" + no2;
    }

    public SensorReading toTemperature(){
        return new SensorReading("Temperature", this.temperature, "C");
    }
}
