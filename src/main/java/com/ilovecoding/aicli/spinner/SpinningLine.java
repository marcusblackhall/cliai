package com.ilovecoding.aicli.spinner;

import java.io.Console;
import java.util.concurrent.TimeUnit;

public class SpinningLine implements Runnable{
    private volatile boolean spinning;
    private static final String spinChars = "|/\\.-_";
    @Override
    public void run() {
        System.out.print("Working on it ....");
        Console console = System.console();
        while (spinning){
            for(int i=0;i< spinChars.length();i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                console.printf("%s","\u0008" +  spinChars.charAt(i));
            }
        }
        console.flush();

    }

    public void stop(){
        this.spinning = false;
    }
    public void start(){
        this.spinning = true;
    }


}
