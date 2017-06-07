package com.example.grpc.server;

import com.example.grpc.GreetingServiceGrpc.GreetingServiceImplBase;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;

/**
 * Created by kamus on 5/06/17.
 */
public class GreetingServiceImpl extends GreetingServiceImplBase {

    @Override
    public void greeting(HelloRequest request,
                         StreamObserver<HelloResponse> responseObserver){

        System.out.println( request );
        String greeting = "Hello there, " + request.getName();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting( greeting )
                .build();

        // send and commit
        responseObserver.onNext( response );
        responseObserver.onCompleted();
    }
}
