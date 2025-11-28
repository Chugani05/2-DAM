package org.rashi;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class HorrocruxesSearch {

    static AtomicBoolean found = new AtomicBoolean(false);
    static volatile String winner = null;

    public static class Search implements Runnable {
        
        String name;
        String location;
        
        public Search(String name, String location) {
            this.name = name;
            this.location = location;
        }      

        @Override
        public void run() {
            int time = ThreadLocalRandom.current().nextInt(500, 2000+1);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!found.get()) {
                found.set(true);
                winner = name;
                System.out.println(name + " found an Horrocrux at " + location + ". Search done!!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread harrySearch = new Thread(new Search("Harry", "the Forbidden Forest"));
        Thread hermioneSearch = new Thread(new Search("Hermione", "the Restricted Section of the library"));
        Thread ronSearch = new Thread(new Search("Ron", "the Slytherin Dungeons"));

        harrySearch.start();
        hermioneSearch.start();
        ronSearch.start();

        harrySearch.join();
        hermioneSearch.join();
        ronSearch.join();
    }

    public static AtomicBoolean getFound() {
        return found;
    }

    public static String getWinner() {
        return winner;
    }
}
