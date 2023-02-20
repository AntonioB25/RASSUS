package hr.fer.rassus.networking;

import hr.fer.rassus.models.Reading;
import hr.fer.rassus.SensorReading;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface SensorReadingApi {

    @POST("sensor/{id}/reading")
    Call<Void> sendReading(@Path("id") Long sensorId, @Body Reading reading);

    @GET("sensor/{id}/allReadings")
    Call<List<SensorReading>> getAllReadings(@Path("id") Long sensorId);

}
