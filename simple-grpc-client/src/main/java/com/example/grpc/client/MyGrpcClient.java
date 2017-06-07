package com.example.grpc.client;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.Sentiment;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Created by kamus on 5/06/17.
 */
public class MyGrpcClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args ){
        //create a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress( HOST, PORT )
                .usePlaintext(true)
                .build();

        //create a blocking stub with the channel
        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        //create a request
        HelloRequest request = HelloRequest.newBuilder()
                .setName( "Mete" )
                .setAge( 33 )
                .setSentiment( Sentiment.HAPPY )
                .build();

        // send the request using the stub
        System.out.println( "Sending request" );
        HelloResponse helloResponse = stub.greeting( request );

        System.out.println("Received response: " + helloResponse.getGreeting());
        channel.shutdown();
    }
}
