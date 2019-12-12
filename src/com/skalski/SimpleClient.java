package com.skalski;

import java.io.IOException;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) throws IOException {
        //creating socket with timeout
        var socket = new Socket("localhost", 59090);
        socket.setSoTimeout(100);

        //byte array to store output
        byte[] b = new byte[1024];

        var input = socket.getInputStream();
        var read = input.read(b, 0, 300);
        var offset = 0;
        while (read != -1) {
            offset += read;
            System.out.println("read: " + read + "bytes");
            read = input.read(b, offset, 300);
        }

        System.out.println("In total read " + offset + " bytes.");
    }
}
