package com.example.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Created by kamus on 5/06/17.
 */
public class MyGrpcServer {

    private static final int SERVER_PORT = 8080;

    public static void main( String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort( SERVER_PORT )
                .addService(new GreetingServiceImpl())
                .build();

        // start server
        System.out.println( "Starting server on port: " + SERVER_PORT );
        server.start();

        // keep it running
        System.out.println("Server started!");
        server.awaitTermination();
    }

}
