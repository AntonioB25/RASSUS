package hr.fer.rassus.grpc;

import hr.fer.rassus.Message;
import hr.fer.rassus.SensorReading;
import hr.fer.rassus.SensorReadingsGrpc;
import hr.fer.rassus.models.Reading;
import hr.fer.rassus.util.Util;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class SensorReadingService extends SensorReadingsGrpc.SensorReadingsImplBase {
    private static final Logger logger = Logger.getLogger(SensorReadingService.class.getName());
    private long startTime;

    public SensorReadingService(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public void requestSensorReadings(Message request, StreamObserver<SensorReading> responseObserver) {
        logger.info("gRPC got a request for new reading: " + request.getPayload() + System.lineSeparator());
        SensorReading response = null;

        //Create response
        try{
             response = Util.getReading(startTime); // Read value from file
        }catch (Exception e){

        }

        //Send response
        responseObserver.onNext(
                response
        );

        logger.info("gRPC responding with:\n" + response + System.lineSeparator());
        responseObserver.onCompleted();
    }
}
