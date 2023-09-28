package com.polytech.tp;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket(InetAddress.getLocalHost(),5000);
            InputStream in = socket.getInputStream();
            StringBuilder message = new StringBuilder();
            for(byte x: in.readAllBytes()){
                message.append((char) x);
            }
            System.out.println(message.toString());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
