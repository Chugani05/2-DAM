package org.rashi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class DungeonsServer.
 * An online dungeon server that manages player entries into their designated
 * dungeons using a FixedThreadPool to efficiently handle threads.
 * 
 * @author Chugani05
 */
public class DungeonServer {

    /**
     * Class DungeonRequest.
     * Represents a player's request to access a specific dungeon.
     * 
     * @author Chugani05
     */
    static class DungeonRequest implements Runnable {
        private final String playerName;
        private final String dungeon;

        /**
         * Constructor assigns the player and the target dungeon.
         */
        public DungeonRequest(String playerName, String dungeon) {
            this.playerName = playerName;
            this.dungeon = dungeon;
        }

        /**
         * Main procedure of the class.
         * This method is executed when the thread runs.
         * It logs the start of the dungeon loading process for the player,
         * including the thread's identifier. It then pauses for a random
         * amount of time to simulate gameplay, and finally logs the completion.
         */
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("[" + threadName + "] Preparing dungeon '" + dungeon +
                    "' for player " + playerName);
            try {
                Thread.sleep(1000 + (int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println("[" + threadName + "] Request from " + playerName + " interrupted");
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("[" + threadName + "] Dungeon '" + dungeon +
                    "' ready for " + playerName + " 🎮");
        }
    }

    public static void main(String[] args) {
        ExecutorService gmBots = Executors.newFixedThreadPool(3);
        String[] players = {
                "Link", "Zelda", "Geralt", "Yennefer", "Gandalf",
                "Frodo", "Aragorn", "Leia", "Luke", "DarthVader"
        };
        String[] dungeons = {
                "Hyrule Catacombs", "Dark Tower", "Moria",
                "Death Star", "Dragon's Nest"
        };
        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            String dungeon = dungeons[i % dungeons.length];
            gmBots.execute(new DungeonRequest(player, dungeon));
        }
        gmBots.shutdown();
        System.out.println("Server: All requests have been sent to the GM bots.");
    }
}