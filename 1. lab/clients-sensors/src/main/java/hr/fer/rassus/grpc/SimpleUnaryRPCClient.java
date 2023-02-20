package hr.fer.rassus.grpc;

import hr.fer.rassus.Message;
import hr.fer.rassus.SensorReading;
import hr.fer.rassus.SensorReadingsGrpc;
import hr.fer.rassus.exceptions.RpcFailedException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * The type Simple unary rpc client.
 */
public class SimpleUnaryRPCClient {

  private static final Logger logger = Logger.getLogger(SimpleUnaryRPCClient.class.getName());


  private final ManagedChannel channel;
  private final SensorReadingsGrpc.SensorReadingsBlockingStub sensorReadingsBlockingStub;

  /**
   * Instantiates a new Simple unary rpc client.
   *
   * @param host the host
   * @param port the port
   */
  public SimpleUnaryRPCClient(String host, int port) {
    this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    sensorReadingsBlockingStub = SensorReadingsGrpc.newBlockingStub(channel);
  }

  /**
   * Stop the client.
   *
   * @throws InterruptedException the interrupted exception
   */
  public void stop() throws InterruptedException {
//    Initiates an orderly shutdown in which preexisting calls continue but new calls are
//    immediately cancelled. Waits for the channel to become terminated, giving up if the timeout
//    is reached.
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * Request uppercase.
   */
  public SensorReading requestSensorReadings() throws Exception {

    final String payload = "send reading";

    Message request = Message.newBuilder()
        .setPayload(payload)
        .build();

    logger.info("gRPC sending: " + request.getPayload() + System.lineSeparator());
    try {
      SensorReading response = sensorReadingsBlockingStub.requestSensorReadings(request);
      logger.info("gRPC received:\n" + response.toString() + System.lineSeparator());
      return response;
    } catch (StatusRuntimeException e) {
      logger.info("RPC failed: " + e.getMessage() + System.lineSeparator());
      throw new RpcFailedException("RPC failed");
    }
  }

}
