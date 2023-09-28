package com.polytech.tp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerResponse extends Thread{

    Socket client;
    String message;
    public ServerResponse(Socket client){
        super();
        this.client = client;
    }
    @Override
    public void run() {
        try{
            OutputStream out = this.client.getOutputStream();
            out.write(message.getBytes(StandardCharsets.UTF_8));
            out.flush();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void send(String message){
        this.message = message.toUpperCase();
        this.start();
    }
}
