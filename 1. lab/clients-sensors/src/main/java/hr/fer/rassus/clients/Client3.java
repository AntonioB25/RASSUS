package hr.fer.rassus.clients;

import hr.fer.rassus.SensorReading;
import hr.fer.rassus.grpc.SensorReadingService;
import hr.fer.rassus.grpc.SimpleUnaryRPCClient;
import hr.fer.rassus.grpc.SimpleUnaryRPCServer;
import hr.fer.rassus.models.Reading;
import hr.fer.rassus.models.Sensor;
import hr.fer.rassus.networking.ApiModule;
import hr.fer.rassus.networking.SensorApi;
import hr.fer.rassus.networking.SensorReadingApi;
import hr.fer.rassus.util.Util;
import retrofit2.Response;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Logger;

public class Client3 {
    private static final Logger logger = Logger.getLogger(Client1.class.getName());

    public static void main(String[] args) throws Exception {

        //start time in millis
        long START_TIME = Calendar.getInstance().getTime().getTime();

        //Initiate
        int port = Util.getFreePort();
        Sensor sensor = new Sensor("127.0.0.3", port);


        //Network client
        SensorReadingApi readingApi = ApiModule.getReadingApi();
        SensorApi sensorApi = ApiModule.getSensorApi();

        //Register on server
        try {
            Response res = sensorApi.registerSensor(sensor).execute();
            String resourceURL = res.headers().get("Location");
            Long id = Long.parseLong(Character.toString(resourceURL.charAt(resourceURL.lastIndexOf('/') + 1))); // read ID from header in response
            sensor.setId(id);

        } catch (IOException e) {
            logger.info("ERROR REACHING SERVER!" + System.lineSeparator());
            System.exit(0);
        }

        // Start gRPC server
        final SimpleUnaryRPCServer server = new SimpleUnaryRPCServer(new SensorReadingService(Calendar.getInstance().getTime().getTime()), sensor.getPort());
        server.start();

        //Ask for closest neighbour
        Sensor closestNeighbour = sensorApi.getClosestNeighbour(sensor.getId()).execute().body();
        logger.info("Closest neighbour: " + closestNeighbour);

        SimpleUnaryRPCClient  closestNeighbourGRPC = null;
        if(closestNeighbour != null){
            logger.info("Closest neighbour: " + closestNeighbour + System.lineSeparator());
            closestNeighbourGRPC = new SimpleUnaryRPCClient(closestNeighbour.getIp(), closestNeighbour.getPort());
        }

        while (true) {
            Reading readingToSend;

            //Read current values
            SensorReading currentReading = Util.getReading(START_TIME);
            logger.info("Current sensor reading:\n" + currentReading.toString() + System.lineSeparator());

            //Ask neighbour for readings with gRPC and calibrate readings
            if (closestNeighbourGRPC != null) {

                try {
                    logger.info("Sensor (id=" + sensor.getId() + ") sends gRPC requtest to Sensor(id=" + closestNeighbour.getId() + ")" + System.lineSeparator());
                    SensorReading neighbourReading = closestNeighbourGRPC.requestSensorReadings();
                    readingToSend = Util.calibrate(currentReading, neighbourReading);
                } catch (Exception e) {
                    logger.info("CANNOT CONNECT TO GRPC SERVER!\n" +
                            "Sending values without calibration" + System.lineSeparator());

                    readingToSend = Reading.sensorReadingToReading(currentReading);
                }
            } else{
                logger.info("No neighbour. Sending values without calibration...");
                readingToSend = Reading.sensorReadingToReading(currentReading);
            }

            //Send readings
            try {
                readingApi.sendReading(sensor.getId(), readingToSend).execute();
                logger.info("Sending values to server:\n" + readingToSend + System.lineSeparator());
            } catch (Exception e) {
                //TODO: terminate
                logger.info("ERROR REACHING SERVER!" +
                        "\nShutting down..." + System.lineSeparator());
            }

            //sleep for 12 seconds
            Thread.sleep(12_000);
        }
    }

}
