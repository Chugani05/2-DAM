package org.rashi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Class CriticalDamageCalculator.
 * Simulates a series of attacks with critical hit chances using multithreading.
 * It calculates the damage for each attack concurrently and then sums up the total damage.
 * 
 * @author Chugani05
 */
public class CriticalDamageCalculator {

    /**
     * Class Attack.
     * Represents an attack made by a character, including its base damage,
     * critical hit probability, and critical damage multiplier.
     * 
     * @author Chugani05
     */
    static class Attack {
        final String attacker;
        final int baseDamage;
        final double critProbability;          // For example, 0.25 = 25%
        final double critMultiplier;           // For example, 2.0 = x2

        /**
         * Constructor that initializes attack attributes.
         * @param attacker Name of the attacker
         * @param baseDamage Base damage value
         * @param critProbability Chance of critical hit
         * @param critMultiplier Damage multiplier for critical hits
         */
        Attack(String attacker, int baseDamage, double critProbability, double critMultiplier) {
            this.attacker = attacker;
            this.baseDamage = baseDamage;
            this.critProbability = critProbability;
            this.critMultiplier = critMultiplier;
        }
    }

    /**
     * Class DamageCalculationTask.
     * Implements Callable to perform damage calculation in a separate thread.
     * It determines if the attack is critical, applies the damage multiplier,
     * and simulates processing delay.
     * 
     * @author Chugani05
     */
    static class DamageCalculationTask implements Callable<Integer> {
        private final Attack attack;

        /**
         * Constructor that takes an Attack object.
         * @param attack The attack to calculate damage for
         */
        DamageCalculationTask(Attack attack) {
            this.attack = attack;
        }

        /**
         * The main logic executed when the thread runs.
         * It logs the start, determines if the attack is critical,
         * applies the damage calculation, simulates delay, and logs the result.
         * @return The final damage dealt
         */
        @Override
        public Integer call() throws Exception {
            String threadName = Thread.currentThread().getName();
            System.out.println("[" + threadName + "] Calculating damage for " + attack.attacker);

            boolean isCritical = Math.random() < attack.critProbability;
            double multiplier = isCritical ? attack.critMultiplier : 1.0;

            Thread.sleep(500 + (int)(Math.random() * 500));

            int finalDamage = (int) (attack.baseDamage * multiplier);
            System.out.println("[" + threadName + "] " + attack.attacker +
                    (isCritical ? " CRITICAL!" : " normal hit") +
                    " -> damage: " + finalDamage);

            return finalDamage;
        }
    }

     /**
     * Main method to execute the damage calculation for multiple attacks concurrently.
     * It creates a thread pool, submits tasks, collects results, and displays total damage.
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        // Simulating a raid
        Attack[] attacks = {
                new Attack("Fire Mage", 120, 0.30, 2.5),
                new Attack("Warrior", 150, 0.15, 2.0),
                new Attack("Rogue", 90, 0.50, 3.0),
                new Attack("Elven Archer", 110, 0.35, 2.2),
                new Attack("Summoner", 80, 0.40, 2.8),
                new Attack("Paladin", 130, 0.10, 1.8),
                new Attack("Barbarian", 160, 0.20, 2.1),
                new Attack("Necromancer", 100, 0.25, 2.3),
        };

        // Submit all tasks to the thread pool
        for (Attack attack : attacks) {
            Future<Integer> future = pool.submit(new DamageCalculationTask(attack));
            futures.add(future);
        }

        // Collect results
        int totalDamage = 0;
        for (int i = 0; i < attacks.length; i++) {
            try {
                int damage = futures.get(i).get(); 
                totalDamage += damage;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Result reading interrupted");
            } catch (ExecutionException e) {
                System.out.println("Error calculating damage: " + e.getCause());
            }
        }

        System.out.println("Total raid damage: " + totalDamage);
        pool.shutdown();
    }
}