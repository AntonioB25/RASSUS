package hr.fer.rassus;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.41.0)",
    comments = "Source: uppercase.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UppercaseGrpc {

  private UppercaseGrpc() {}

  public static final String SERVICE_NAME = "hr.fer.rassus.Uppercase";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<hr.fer.rassus.Message,
      hr.fer.rassus.Message> getRequestUppercaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestUppercase",
      requestType = hr.fer.rassus.Message.class,
      responseType = hr.fer.rassus.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<hr.fer.rassus.Message,
      hr.fer.rassus.Message> getRequestUppercaseMethod() {
    io.grpc.MethodDescriptor<hr.fer.rassus.Message, hr.fer.rassus.Message> getRequestUppercaseMethod;
    if ((getRequestUppercaseMethod = UppercaseGrpc.getRequestUppercaseMethod) == null) {
      synchronized (UppercaseGrpc.class) {
        if ((getRequestUppercaseMethod = UppercaseGrpc.getRequestUppercaseMethod) == null) {
          UppercaseGrpc.getRequestUppercaseMethod = getRequestUppercaseMethod =
              io.grpc.MethodDescriptor.<hr.fer.rassus.Message, hr.fer.rassus.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestUppercase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hr.fer.rassus.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  hr.fer.rassus.Message.getDefaultInstance()))
              .setSchemaDescriptor(new UppercaseMethodDescriptorSupplier("RequestUppercase"))
              .build();
        }
      }
    }
    return getRequestUppercaseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UppercaseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UppercaseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UppercaseStub>() {
        @java.lang.Override
        public UppercaseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UppercaseStub(channel, callOptions);
        }
      };
    return UppercaseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UppercaseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UppercaseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UppercaseBlockingStub>() {
        @java.lang.Override
        public UppercaseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UppercaseBlockingStub(channel, callOptions);
        }
      };
    return UppercaseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UppercaseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UppercaseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UppercaseFutureStub>() {
        @java.lang.Override
        public UppercaseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UppercaseFutureStub(channel, callOptions);
        }
      };
    return UppercaseFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UppercaseImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestUppercase(hr.fer.rassus.Message request,
        io.grpc.stub.StreamObserver<hr.fer.rassus.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestUppercaseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestUppercaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                hr.fer.rassus.Message,
                hr.fer.rassus.Message>(
                  this, METHODID_REQUEST_UPPERCASE)))
          .build();
    }
  }

  /**
   */
  public static final class UppercaseStub extends io.grpc.stub.AbstractAsyncStub<UppercaseStub> {
    private UppercaseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UppercaseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UppercaseStub(channel, callOptions);
    }

    /**
     */
    public void requestUppercase(hr.fer.rassus.Message request,
        io.grpc.stub.StreamObserver<hr.fer.rassus.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestUppercaseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UppercaseBlockingStub extends io.grpc.stub.AbstractBlockingStub<UppercaseBlockingStub> {
    private UppercaseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UppercaseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UppercaseBlockingStub(channel, callOptions);
    }

    /**
     */
    public hr.fer.rassus.Message requestUppercase(hr.fer.rassus.Message request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestUppercaseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UppercaseFutureStub extends io.grpc.stub.AbstractFutureStub<UppercaseFutureStub> {
    private UppercaseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UppercaseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UppercaseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hr.fer.rassus.Message> requestUppercase(
        hr.fer.rassus.Message request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestUppercaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_UPPERCASE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UppercaseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UppercaseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_UPPERCASE:
          serviceImpl.requestUppercase((hr.fer.rassus.Message) request,
              (io.grpc.stub.StreamObserver<hr.fer.rassus.Message>) responseObserver);
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

  private static abstract class UppercaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UppercaseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hr.fer.rassus.UppercaseOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Uppercase");
    }
  }

  private static final class UppercaseFileDescriptorSupplier
      extends UppercaseBaseDescriptorSupplier {
    UppercaseFileDescriptorSupplier() {}
  }

  private static final class UppercaseMethodDescriptorSupplier
      extends UppercaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UppercaseMethodDescriptorSupplier(String methodName) {
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
      synchronized (UppercaseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UppercaseFileDescriptorSupplier())
              .addMethod(getRequestUppercaseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
