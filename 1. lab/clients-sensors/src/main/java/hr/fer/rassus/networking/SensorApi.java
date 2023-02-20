package hr.fer.rassus.networking;

import hr.fer.rassus.models.Sensor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface SensorApi {

    @GET("sensor/{id}/closestNeighbour")
    Call<Sensor> getClosestNeighbour(@Path("id") Long sensorId);

    @GET("sensor/allSensors")
    Call<List<Sensor>> getAllSensors();

    @POST("sensor/register")
    Call<Void> registerSensor(@Body Sensor sensor);
}
