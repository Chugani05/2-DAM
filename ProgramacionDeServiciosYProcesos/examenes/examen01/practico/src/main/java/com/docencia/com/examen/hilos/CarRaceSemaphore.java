package com.docencia.com.examen.hilos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase CarRaceSemaphore
 * Simula una carrera entre Rayo McQueen y Mate, controlando los turnos mediante un semaforo.
 * @author Chugani05
 */
public class CarRaceSemaphore implements Runnable {

    private String name;
    private int goal;
    private int distance = 0;
    public static volatile Boolean winner = false;

    private static final Semaphore semaphore = new Semaphore(1, true);

    /**
     * Constructor por defecto.
     */
    public CarRaceSemaphore() {
    };

    /**
     * Constructor con asignacion de los parametros.
     * @param name Nombre del coche competidor.
     * @param goal Meta del coche competidor.
     */
    public CarRaceSemaphore(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    @Override
    public void run() {
        while (distance < goal && !winner) {
            try {
                semaphore.acquire();
                int turn = semaphore.availablePermits() + 1;
                int randDinstance = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                distance += randDinstance;
                System.out.println(name + " ha recorrido " + randDinstance + " metros. Distancia recorrida " + distance);
                Thread.sleep(ThreadLocalRandom.current().nextInt(250, 800 + 1));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        }
        System.out.println(this.name + " ha ganado la carrera.");
    }

    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("    🏁 CARRERA DE COCHES 🏁");
        System.out.println("   Rayo-McQueen vs Mate");

        System.out.println("═══════════════════════════════════════");

        int raceGoal = 100;

        Thread rayoMcQueen = new Thread(new CarRaceSemaphore("Rayo-McQueen", raceGoal));
        Thread mate = new Thread(new CarRaceSemaphore("Mate", raceGoal));

        rayoMcQueen.start();
        mate.start();

        try {
            rayoMcQueen.join();
            mate.join();

            System.out.println("\n═══════════════════════════════════════");
            System.out.println("        🏁 CARRERA TERMINADA 🏁");
            System.out.println("═══════════════════════════════════════");

        } catch (InterruptedException e) {
            System.out.println("La carrera fue interrumpida!");
        }
    }

}
