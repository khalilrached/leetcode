package com.polytech.udp;

import com.polytech.util.DownloadBar;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Random;

public class Client {
    public static final String dirname = "./download/";
    public DownloadBar bar = new DownloadBar("");
    public void download() {
        try{
            byte[] data_bytes = new byte[Server.MAX_FILE_SIZE];
            DatagramPacket data = new DatagramPacket(data_bytes,Server.MAX_FILE_SIZE);
            MulticastSocket socket = new MulticastSocket(5000);
            InetAddress group = InetAddress.getByName("224.0.0.5");
            socket.joinGroup(group);
            socket.receive(data);
            byte[] actual_data = Arrays.copyOf(data_bytes,data.getLength());
            File file;
            int file_number = 1;
            do {
                String filename = "file_"+String.valueOf(file_number)+".txt";
                file = new File(dirname+filename);
                file_number++;
            }while (file.exists());
            bar.message = "Downloading file => "+file.getPath();
            boolean created = file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            int one_percent = actual_data.length/100;
            int i = 0;
            for(byte x: actual_data){
                // random sleep time
                int t = (int)(Math.random()*100) + 100;
                Thread.sleep(t);
                if(i>=one_percent) {
                    this.bar.slide();
                    i = 0;
                }
                i++;
                out.write(x);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
