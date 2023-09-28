package com.polytech.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    public static final int MAX_FILE_SIZE = 2000;
    public static void main(String[] args) {
        try{
            File file = new File("./shared/shared_file.txt");
            if(!file.exists()){
                System.out.println("file does not exist!");
                System.exit(0);
            }
            FileInputStream reader = new FileInputStream(file);
            byte[] message = reader.readAllBytes();
            InetAddress group = InetAddress.getByName("224.0.0.5");
            if(message.length > MAX_FILE_SIZE){
                message =  Arrays.copyOf(message,MAX_FILE_SIZE);
            }
            DatagramPacket data_packet = new DatagramPacket(message,message.length,group,5000);
            MulticastSocket socket = new MulticastSocket();
            socket.send(data_packet);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
