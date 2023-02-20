package hr.fer.rassus.models;


import com.google.gson.annotations.SerializedName;
import com.opencsv.bean.CsvBindByName;
import hr.fer.rassus.SensorReading;
import org.apache.commons.math3.util.Precision;

import java.lang.reflect.Field;

public class Reading {

    @CsvBindByName
    @SerializedName("temperature")
    private Double temperature = null;
    @CsvBindByName
    @SerializedName("pressure")
    private Double pressure = null;
    @CsvBindByName
    @SerializedName("humidity")
    private Double humidity = null;
    @CsvBindByName
    @SerializedName("co")
    private Double co = null;
    @CsvBindByName
    @SerializedName("so2")
    private Double so2 = null;
    @CsvBindByName
    @SerializedName("no2")
    private Double no2 = null;

    public Reading() {
    }

    public Reading(Double temperature, Double pressure, Double humidity, Double co, Double so2, Double no2) {
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

    public SensorReading toSensorReading() {
        SensorReading.Builder sb = SensorReading
                .newBuilder()
                .setTemperature(this.getTemperature())
                .setHumidity(this.getHumidity())
                .setPressure(this.getPressure())
                .setCo(this.getCo());

        //if null set to 0 else set value
        if (this.getNo2() == null) {
            sb.setNo2(0.0);
        } else {
            sb.setNo2(this.getNo2());
        }

        if (this.getSo2() == null) {
            sb.setSo2(0.0);
        } else {
            sb.setSo2(this.getSo2());
        }

        return sb.build();
    }

    /**
     * Converst SensorReading to Reading object
     *
     * @param sR SensorReading object
     * @return Reading object
     */
    public static Reading sensorReadingToReading(SensorReading sR) throws IllegalAccessException {
        Reading reading = new Reading(sR.getTemperature(), sR.getPressure(), sR.getHumidity(), sR.getCo(), sR.getSo2(), sR.getNo2());
        double epsilon = 0.000001d;

        Field[] fields = reading.getClass().getDeclaredFields();
        for (Field f : fields) {
            Object v = f.get(reading);
            if (Precision.equals(((Number) v).doubleValue(), 0.0, epsilon))
                f.set(reading, null);
        }

        return reading;
    }
}
