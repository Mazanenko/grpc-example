package com.example.grpcclient.service;

import com.example.grpcservice.grpc.lib.HelloRequest;
import com.example.grpcservice.grpc.lib.MyServiceGrpc;
import io.grpc.StatusRuntimeException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("grpc-server")
    private MyServiceGrpc.MyServiceBlockingStub stub;

    public String sendMessage(String message) {
        System.out.println(message);
        return stub.sayHello(HelloRequest.newBuilder()
                .setName(message)
                .build()).getMessage();
    }
}
