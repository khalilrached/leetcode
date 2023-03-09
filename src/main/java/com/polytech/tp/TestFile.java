package com.polytech.tp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TestFile {
    public static void main(String[] args) {
        try{
            File test = new File("C:\\Users\\Zoro\\Desktop\\www\\leetcode\\src\\main\\resources\\text.txt");
            if(!test.exists())
                test.createNewFile();
            FileInputStream stream = new FileInputStream(test);
            FileOutputStream out = new FileOutputStream(test);
            StringBuilder builder = new StringBuilder();
            // InetAddress group = InetAddress.getByName("");
            InetAddress group = InetAddress.getByName("224.0.0.1");
            DatagramPacket packet = new DatagramPacket(stream.readAllBytes(),stream.readAllBytes().length, group,5000);
            MulticastSocket socket = new MulticastSocket();
            socket.send(packet);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
