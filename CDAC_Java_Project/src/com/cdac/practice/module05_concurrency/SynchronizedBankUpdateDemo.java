package com.cdac.practice.module05_concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates race condition prevention using synchronized methods
 * during concurrent balance updates by multiple threads.
 */
class SharedAccount {
    private int balance;

    public SharedAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit ensures atomic read-modify-write
    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    // Synchronized withdraw ensures atomic update
    public synchronized void withdraw(int amount) {
        this.balance -= amount;
    }

    public synchronized int getBalance() {
        return this.balance;
    }
}

public class SynchronizedBankUpdateDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Concurrent Synchronized Bank Updates Demo ===\n");

        final int INITIAL_BALANCE = 10000;
        final int NUM_THREADS = 10;
        final int TRANSACTIONS_PER_THREAD = 1000;
        final int AMOUNT = 10;

        SharedAccount account = new SharedAccount(INITIAL_BALANCE);
        System.out.printf("Starting Balance: ₹%d%n", account.getBalance());
        System.out.printf("Running %d threads doing %d balanced deposits and withdrawals each...%n",
                NUM_THREADS, TRANSACTIONS_PER_THREAD);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < TRANSACTIONS_PER_THREAD; j++) {
                    account.deposit(AMOUNT);
                    account.withdraw(AMOUNT);
                }
            }, "Worker-" + i);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.printf("Final Balance   : ₹%d%n", account.getBalance());
        System.out.printf("Expected Balance: ₹%d%n", INITIAL_BALANCE);
        System.out.println("Integrity Check : " + (account.getBalance() == INITIAL_BALANCE ? "PASSED (No Race Condition)" : "FAILED (Race Condition Detected)"));
    }
}
