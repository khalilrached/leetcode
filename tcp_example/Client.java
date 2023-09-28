package com.polytech.tp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket(InetAddress.getLocalHost(),5000);
            OutputStream out = socket.getOutputStream();
            File test = new File("text.txt");
            FileInputStream stream = new FileInputStream(test);
            String lower_case = "hello world";
            out.write(lower_case.getBytes(StandardCharsets.UTF_8));
            out.flush();
            if(socket.isOutputShutdown()) System.out.println("output shutdown");
            InputStream in = socket.getInputStream();
            StringBuilder message = new StringBuilder();
            for(byte x: in.readAllBytes()){
                System.out.println("here");
                message.append((char) x);
            }
            System.out.println(message.toString());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
