package com.cdac.practice.module05_concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classic Producer-Consumer coordination problem solved using
 * synchronized methods, wait(), and notifyAll() on a bounded buffer.
 */
class BoundedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.printf("[%s] Buffer is FULL. Producer waiting...%n", Thread.currentThread().getName());
            wait();
        }

        queue.add(item);
        System.out.printf("[%s] PRODUCED item: %d (Buffer size: %d/%d)%n",
                Thread.currentThread().getName(), item, queue.size(), capacity);

        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.printf("[%s] Buffer is EMPTY. Consumer waiting...%n", Thread.currentThread().getName());
            wait();
        }

        int item = queue.poll();
        System.out.printf("[%s] CONSUMED item: %d (Buffer size: %d/%d)%n",
                Thread.currentThread().getName(), item, queue.size(), capacity);

        notifyAll();
        return item;
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        System.out.println("=== Producer-Consumer Concurrency Demo ===\n");

        BoundedBuffer buffer = new BoundedBuffer(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    buffer.produce(i * 100);
                    Thread.sleep(150); // Simulates production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer-Thread");

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    buffer.consume();
                    Thread.sleep(300); // Simulates consumption delay (slower)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer-Thread");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll items produced and consumed successfully.");
    }
}
