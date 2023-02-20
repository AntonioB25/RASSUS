package hr.fer.rassus;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.41.0)",
    comments = "Source: uppercase.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SensorReadingsGrpc {

  private SensorReadingsGrpc() {}

  public static final String SERVICE_NAME = "hr.fer.rassus.SensorReadings";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<hr.fer.rassus.Message,
      hr.fer.rassus.SensorReading> getRequestSensorReadingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestSensorReadings",
      requestType = hr.fer.rassus.Message.class,
      responseType = hr.fer.rassus.SensorReading.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hr.fer.rassus.Message,
      hr.fer.rassus.SensorReading> getRequestSensorReadingsMethod() {
    io.grpc.MethodDescriptor<hr.fer.rassus.Message, hr.fer.rassus.SensorReading> getRequestSensorReadingsMethod;
    if ((getRequestSensorReadingsMethod = SensorReadingsGrpc.getRequestSensorReadingsMethod) == null) {
      synchronized (SensorReadingsGrpc.class) {
        if ((getRequestSensorReadingsMethod = SensorReadingsGrpc.getRequestSensorReadingsMethod) == null) {
          SensorReadingsGrpc.getRequestSensorReadingsMethod = getRequestSensorReadingsMethod =
              io.grpc.MethodDescriptor.<hr.fer.rassus.Message, hr.fer.rassus.SensorReading>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestSensorReadings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hr.fer.rassus.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hr.fer.rassus.SensorReading.getDefaultInstance()))
              .setSchemaDescriptor(new SensorReadingsMethodDescriptorSupplier("RequestSensorReadings"))
              .build();
        }
      }
    }
    return getRequestSensorReadingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SensorReadingsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorReadingsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorReadingsStub>() {
        @java.lang.Override
        public SensorReadingsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorReadingsStub(channel, callOptions);
        }
      };
    return SensorReadingsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SensorReadingsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorReadingsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorReadingsBlockingStub>() {
        @java.lang.Override
        public SensorReadingsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorReadingsBlockingStub(channel, callOptions);
        }
      };
    return SensorReadingsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SensorReadingsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorReadingsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorReadingsFutureStub>() {
        @java.lang.Override
        public SensorReadingsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorReadingsFutureStub(channel, callOptions);
        }
      };
    return SensorReadingsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SensorReadingsImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestSensorReadings(hr.fer.rassus.Message request,
        io.grpc.stub.StreamObserver<hr.fer.rassus.SensorReading> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestSensorReadingsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestSensorReadingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                hr.fer.rassus.Message,
                hr.fer.rassus.SensorReading>(
                  this, METHODID_REQUEST_SENSOR_READINGS)))
          .build();
    }
  }

  /**
   */
  public static final class SensorReadingsStub extends io.grpc.stub.AbstractAsyncStub<SensorReadingsStub> {
    private SensorReadingsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorReadingsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorReadingsStub(channel, callOptions);
    }

    /**
     */
    public void requestSensorReadings(hr.fer.rassus.Message request,
        io.grpc.stub.StreamObserver<hr.fer.rassus.SensorReading> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestSensorReadingsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SensorReadingsBlockingStub extends io.grpc.stub.AbstractBlockingStub<SensorReadingsBlockingStub> {
    private SensorReadingsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorReadingsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorReadingsBlockingStub(channel, callOptions);
    }

    /**
     */
    public hr.fer.rassus.SensorReading requestSensorReadings(hr.fer.rassus.Message request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestSensorReadingsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SensorReadingsFutureStub extends io.grpc.stub.AbstractFutureStub<SensorReadingsFutureStub> {
    private SensorReadingsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorReadingsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorReadingsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hr.fer.rassus.SensorReading> requestSensorReadings(
        hr.fer.rassus.Message request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestSensorReadingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_SENSOR_READINGS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SensorReadingsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SensorReadingsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_SENSOR_READINGS:
          serviceImpl.requestSensorReadings((hr.fer.rassus.Message) request,
              (io.grpc.stub.StreamObserver<hr.fer.rassus.SensorReading>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SensorReadingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SensorReadingsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hr.fer.rassus.UppercaseOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SensorReadings");
    }
  }

  private static final class SensorReadingsFileDescriptorSupplier
      extends SensorReadingsBaseDescriptorSupplier {
    SensorReadingsFileDescriptorSupplier() {}
  }

  private static final class SensorReadingsMethodDescriptorSupplier
      extends SensorReadingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SensorReadingsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SensorReadingsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SensorReadingsFileDescriptorSupplier())
              .addMethod(getRequestSensorReadingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
