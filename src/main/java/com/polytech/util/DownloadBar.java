package com.polytech.util;

import com.polytech.udp.MainActivity;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;

public class DownloadBar {
    public String message;
    public int percent;
    public DownloadBar(String message){
        this.message = message;
    }

    public void slide(){
        if(percent<100) percent++;
        MainActivity.ClientThread.log();
    }

    @Override
    public String toString() {
        return message + ": [" + "=".repeat(Math.max(0, percent)) + ">" + " ".repeat(100 - percent) + "] [ "+percent+"% ]";
    }
}
