package hr.fer.rassus.models;

import java.util.concurrent.ThreadLocalRandom;

public class GeoLocation {
    private Double latitude;
    private Double longitude;

    public GeoLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

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


    /**
     * Generates new sensors.GeoLocation
     * in range [15.87, 16] for longitude and [45.75, 45.85] for latitude
     * @return new sensors.GeoLocation
     */
//    public static GeoLocation generateGeoLocation(){
//        double LAT_MIN = 15.87;
//        double LAT_MAX = 16.0;
//        double LON_MIN = 45.75;
//        double LON_MAX = 45.85;
//
//        Double latitude = ThreadLocalRandom.current().nextDouble() * (LAT_MAX - LAT_MIN) + LAT_MIN;
//        Double longitude = ThreadLocalRandom.current().nextDouble() * (LON_MAX - LON_MIN) + LON_MIN;
//
//        return new GeoLocation(latitude,longitude);
//    }

    @Override
    public String toString() {
        return "sensors.GeoLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
