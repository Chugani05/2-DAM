package org.rashi;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Class OpenWorldSwap.
 * Simulates swapping entities or objects in an open-world environment.
 * Uses multithreading to perform swap operations concurrently.
 * This example demonstrates how to manage multiple swap tasks and synchronize their completion.
 * 
 * @author Chugani05
 */
public class OpenWorldSpawns {

    /**
     * Class SwapTask.
     * Represents a swap operation for an entity in the open world.
     * It simulates the process of swapping an entity with a delay.
     * 
     * @author Chugani05
     */
    static class SpawnTask implements Runnable {

        private final String[] zones = {
                "Cursed Forest",
                "Ancient Ruins",
                "Radioactive Swamp",
                "Cybernetic City",
                "Forbidden Temple"
        };

        private final String[] enemies = {
                "Mutant Slime",
                "Warrior Skeleton",
                "Mecha-Dragon",
                "Desert Bandit",
                "Supreme Lich"
        };

        /**
         * The main logic executed when the thread runs.
         * It simulates the swap operation with a delay and logs the process.
         * @return A message indicating the swap completion
         */
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            String zone = zones[(int)(Math.random() * zones.length)];
            String enemy = enemies[(int)(Math.random() * enemies.length)];
            System.out.println("[" + LocalTime.now() + "][" + threadName + "] Spawn of " +
                    enemy + " in " + zone);
        }
    }

    /**
     * Main method to execute multiple swap operations concurrently.
     * Creates a thread pool, submits swap tasks, and waits for all to finish.
     * It then prints a summary message.
     */
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Execute the task every 2 seconds, without initial delay
        scheduler.scheduleAtFixedRate(new SpawnTask(), 0, 2, TimeUnit.SECONDS);

        // Let the “world” live for 12 seconds
        Thread.sleep(12000);

        // Graceful shutdown
        System.out.println("Stopping spawns...");
        scheduler.shutdown();
        if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forcing spawn shutdown.");
            scheduler.shutdownNow();
        }
        System.out.println("Open world server stopped.");
    }
}