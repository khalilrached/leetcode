package com.polytech.tp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
    static ServerSocket serverSocket ;


    public static void main(String[] args) {
        Socket socket;
        try{
            serverSocket = new ServerSocket(5000,10);
            System.out.println("server started");
            while (true){
                socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                System.out.println(in);
                StringBuilder message = new StringBuilder();
                for(byte x: in.readAllBytes()){
                    message.append((char) x);
                }

                if (socket.isConnected()) {
                    ServerResponse res = new ServerResponse(socket);
                    res.send(message.toString());
                }
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
