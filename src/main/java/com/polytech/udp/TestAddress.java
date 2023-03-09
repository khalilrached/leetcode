package com.polytech.udp;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class TestAddress {
    public static void main(String[] args) {
        File log = new File("log.txt");
        boolean file_created = false;
        FileOutputStream out = null;
        try{
            if(!log.exists()) file_created = log.createNewFile();
            out = new FileOutputStream(log);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        for(int i = 0;i<255;i++){
            String name = "224.0.0." + String.valueOf(i);
            System.out.println("address: "+name);
            try{
                String message = "hello world!";
                InetAddress group = InetAddress.getByName(name);
                DatagramPacket packet = new DatagramPacket(message.getBytes(StandardCharsets.UTF_8),message.length(),group,5000);
                MulticastSocket socket = new MulticastSocket();
                socket.send(packet);
                String w = name + " work\n";
                out.write(w.getBytes(StandardCharsets.UTF_8));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
