package com.example.grpcservice.service.grpc;

import com.example.grpcservice.grpc.lib.HelloReply;
import com.example.grpcservice.grpc.lib.HelloRequest;
import com.example.grpcservice.grpc.lib.MyServiceGrpc;

import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.Instant;


@GrpcService
public class MiServiceImpl extends MyServiceGrpc.MyServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        Instant instant = Instant.now();
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .setTimestamp(Timestamp.newBuilder()
                        .setSeconds(instant.getEpochSecond())
                        .setNanos(instant.getNano()))
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
