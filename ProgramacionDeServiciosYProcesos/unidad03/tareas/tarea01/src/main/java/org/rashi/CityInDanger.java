package org.rashi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CityInDanger { 

    static AtomicBoolean threatNeutralized = new AtomicBoolean(false);
    List<String> zoneA = Arrays.asList("North", "Center", "East");
    List<String> zoneB = Arrays.asList("West", "South");
    static volatile String winner = null;

    runnable Superman:
        for zona in zonasA:
            if amenazaNeutralizada: break
            Sleep(RandomInt(200, 500))
            System.out.println("Superman salvó " + zona);
        if not amenazaNeutralizada:
            amenazaNeutralizada = true
            ganador = "Superman"
            System.out.println("Amenaza neutralizada por Superman");

    runnable Batman:
        for zona in zonasB:
            if amenazaNeutralizada: break
            Sleep(RandomInt(300, 600))
            System.out.println("Batman salvó " + zona);
        if not amenazaNeutralizada:
            amenazaNeutralizada = true
            ganador = "Batman"
            System.out.println("Amenaza neutralizada por Batman");

    public static void main(String[] args) {
        Thread supermanThread = new Thread(new Superman());
        Thread batmanThread = new Thread(new Batman());
        
        supermanThread.start();
        batmanThread.start();
        
        supermanThread.join();
        batmanThread.join();
    } 
        

    public static AtomicBoolean getThreatNeutralized() {
        return threatNeutralized;
    }

    public static String getWinner() {
        return winner;
    }
}
