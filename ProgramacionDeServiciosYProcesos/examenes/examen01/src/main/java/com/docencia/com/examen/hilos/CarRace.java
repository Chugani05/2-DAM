package com.docencia.com.examen.hilos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase CarRace
 * Simula una carrera entre Rayo McQueen y Mate, asignandole nombre y meta.
 * 
 * @author Chugani05
 */
public class CarRace implements Runnable {
    private String name;
    private int distance = 0;
    private int goal;
    public static volatile Boolean winner = false;

    public CarRace(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    /**
     * Asigna una distancia random a los participantes en su turno hasta que uno de
     * ellos supere la meta.
     */
    @Override
    public void run() {
        while (distance < goal) {
            int timeInMs = ThreadLocalRandom.current().nextInt(500, 2000 + 1);
            try {
                Thread.sleep(timeInMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            int randDinstance = ThreadLocalRandom.current().nextInt(10, 100 + 1);
            distance += randDinstance;
            System.out.println(
                    this.name + " ha recorrido " + randDinstance + " metros. Distancia recorrida " + this.distance);

            if (distance > goal) {
                winner = true;
                System.out.println("Carrera terminada. " + this.name + " ha ganado la carrera.");
                break;
            }
            
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread mcqueen = new Thread(new CarRace("Rayo McQueen", 1000));
        Thread mate = new Thread(new CarRace("Mate", 1000));

        mcqueen.start();
        mate.start();

        mcqueen.join();
        mate.join();
    }
}
