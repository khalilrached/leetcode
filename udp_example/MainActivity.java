package com.polytech.udp;

import com.polytech.util.DownloadBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    public static class ClientThread extends Thread{
        public static int NUMBER = 0;
        public static List<DownloadBar> bars = new ArrayList<>();
        public Client client;
        public ClientThread(){
            super();
            NUMBER++;
            this.client = new Client();
            bars.add(this.client.bar);
        }

        public static void log(){
            try{
                Runtime.getRuntime().exec("clear");
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            bars.forEach(System.out::println);
        }

        @Override
        public void run() {
            System.out.println("Client Listen.");
            client.download();
        }
    }
    public static void main(String[] args) {
        Thread server_thread = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Server started");
                Server.main(null);
            }
        };
        List<Thread> threads = new ArrayList<>();
        threads.add(new ClientThread());
        threads.add(new ClientThread());
        threads.add(new ClientThread());
        threads.add(new ClientThread());
        System.out.println("Number of client listening: "+ClientThread.NUMBER);
        // start all threads
        threads.forEach(Thread::start);
        server_thread.start();
    }
}
