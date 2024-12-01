package cn.tansorflow.server.protocol;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: postInfo.proto")
public final class UpdateServerInfoGrpc {

  private UpdateServerInfoGrpc() {}

  public static final String SERVICE_NAME = "UpdateServerInfo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.tansorflow.server.protocol.ClientInfo,
      cn.tansorflow.server.protocol.MyResponse> getUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateInfo",
      requestType = cn.tansorflow.server.protocol.ClientInfo.class,
      responseType = cn.tansorflow.server.protocol.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.tansorflow.server.protocol.ClientInfo,
      cn.tansorflow.server.protocol.MyResponse> getUpdateInfoMethod() {
    io.grpc.MethodDescriptor<cn.tansorflow.server.protocol.ClientInfo, cn.tansorflow.server.protocol.MyResponse> getUpdateInfoMethod;
    if ((getUpdateInfoMethod = UpdateServerInfoGrpc.getUpdateInfoMethod) == null) {
      synchronized (UpdateServerInfoGrpc.class) {
        if ((getUpdateInfoMethod = UpdateServerInfoGrpc.getUpdateInfoMethod) == null) {
          UpdateServerInfoGrpc.getUpdateInfoMethod = getUpdateInfoMethod =
              io.grpc.MethodDescriptor.<cn.tansorflow.server.protocol.ClientInfo, cn.tansorflow.server.protocol.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.tansorflow.server.protocol.ClientInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.tansorflow.server.protocol.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UpdateServerInfoMethodDescriptorSupplier("updateInfo"))
              .build();
        }
      }
    }
    return getUpdateInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UpdateServerInfoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateServerInfoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateServerInfoStub>() {
        @java.lang.Override
        public UpdateServerInfoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateServerInfoStub(channel, callOptions);
        }
      };
    return UpdateServerInfoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UpdateServerInfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateServerInfoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateServerInfoBlockingStub>() {
        @java.lang.Override
        public UpdateServerInfoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateServerInfoBlockingStub(channel, callOptions);
        }
      };
    return UpdateServerInfoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UpdateServerInfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateServerInfoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateServerInfoFutureStub>() {
        @java.lang.Override
        public UpdateServerInfoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateServerInfoFutureStub(channel, callOptions);
        }
      };
    return UpdateServerInfoFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UpdateServerInfoImplBase implements io.grpc.BindableService {

    /**
     */
    public void updateInfo(cn.tansorflow.server.protocol.ClientInfo request,
        io.grpc.stub.StreamObserver<cn.tansorflow.server.protocol.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.tansorflow.server.protocol.ClientInfo,
                cn.tansorflow.server.protocol.MyResponse>(
                  this, METHODID_UPDATE_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class UpdateServerInfoStub extends io.grpc.stub.AbstractAsyncStub<UpdateServerInfoStub> {
    private UpdateServerInfoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateServerInfoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateServerInfoStub(channel, callOptions);
    }

    /**
     */
    public void updateInfo(cn.tansorflow.server.protocol.ClientInfo request,
        io.grpc.stub.StreamObserver<cn.tansorflow.server.protocol.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UpdateServerInfoBlockingStub extends io.grpc.stub.AbstractBlockingStub<UpdateServerInfoBlockingStub> {
    private UpdateServerInfoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateServerInfoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateServerInfoBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.tansorflow.server.protocol.MyResponse updateInfo(cn.tansorflow.server.protocol.ClientInfo request) {
      return blockingUnaryCall(
          getChannel(), getUpdateInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UpdateServerInfoFutureStub extends io.grpc.stub.AbstractFutureStub<UpdateServerInfoFutureStub> {
    private UpdateServerInfoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateServerInfoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateServerInfoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.tansorflow.server.protocol.MyResponse> updateInfo(
        cn.tansorflow.server.protocol.ClientInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UpdateServerInfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UpdateServerInfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_INFO:
          serviceImpl.updateInfo((cn.tansorflow.server.protocol.ClientInfo) request,
              (io.grpc.stub.StreamObserver<cn.tansorflow.server.protocol.MyResponse>) responseObserver);
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

  private static abstract class UpdateServerInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UpdateServerInfoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.tansorflow.server.protocol.PostInfo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UpdateServerInfo");
    }
  }

  private static final class UpdateServerInfoFileDescriptorSupplier
      extends UpdateServerInfoBaseDescriptorSupplier {
    UpdateServerInfoFileDescriptorSupplier() {}
  }

  private static final class UpdateServerInfoMethodDescriptorSupplier
      extends UpdateServerInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UpdateServerInfoMethodDescriptorSupplier(String methodName) {
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
      synchronized (UpdateServerInfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UpdateServerInfoFileDescriptorSupplier())
              .addMethod(getUpdateInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
