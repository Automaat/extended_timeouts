package com.skalski;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //starting server
        try (var listener = new ServerSocket(59090)) {
            System.out.println("The simple server is running...");

            //message to send
            byte[] test = {1};

            while (true) {
                try (var socket = listener.accept()) {
                    System.out.println("Accepted connection");
                    OutputStream outputStream = socket.getOutputStream();
                    for (int i = 0; i < 200; i++) {
                        outputStream.write(test);
                        //simulating slow connection
                        sleep(90);
                    }
                    outputStream.close();
                }
            }
        }
    }
}
