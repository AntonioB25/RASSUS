package hr.fer.rassus.networking;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiModule {

    private SensorReadingApi readingApi;
    private SensorApi sensorApi;
    static Retrofit retrofit;

    private ApiModule() {

    }

    public static SensorReadingApi getReadingApi() {
        if (retrofit == null) {
           instantiate();
        }

        return retrofit.create(SensorReadingApi.class);
    }

    public static SensorApi getSensorApi() {
        if (retrofit == null) {
            instantiate();
        }

        return retrofit.create(SensorApi.class);
    }

    private static void instantiate(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://localhost:8090/api/")
                .build();
    }


}
