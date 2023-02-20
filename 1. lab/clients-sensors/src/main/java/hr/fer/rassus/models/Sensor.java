package hr.fer.rassus.models;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.math3.util.Precision;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;


public class Sensor {

    @SerializedName("id")
    private Long id=null;
    @SerializedName("latitude")
    private Double latitude;
    @SerializedName("longitude")
    private Double longitude;
    @SerializedName("ip")
    private String ip;
    @SerializedName("port")
    private Integer port;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public Sensor(String ip, Integer port) {
        generateLocation();
        this.ip = ip;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Generates and sets latitude and longitude
     * in range [15.87, 16] for longitude and [45.75, 45.85] for latitude
     */
    public void generateLocation() {
        Double lat, lon;

        double LAT_MIN = 15.87;
        double LAT_MAX = 16.0;

        double LON_MIN = 45.75;
        double LON_MAX = 45.85;

        lat = ThreadLocalRandom.current().nextDouble() * (LAT_MAX - LAT_MIN) + LAT_MIN;
        lon = ThreadLocalRandom.current().nextDouble() * (LON_MAX - LON_MIN) + LON_MIN;

        this.latitude = Precision.round(lat, 2);
        this.longitude = Precision.round(lon, 2);
    }

    @Override
    public String toString() {
        return "Sensor:\n" +
                "latitude=" + latitude +
                "\nlongitude=" + longitude +
                "\nip='" + ip + '\'' +
                "\nport=" + port;
    }
}
