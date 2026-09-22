package com.cdac.practice.module04_streams;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Generates the first 50 Fibonacci numbers using Stream.iterate.
 * Uses BigInteger to prevent numerical overflow beyond the 92nd Fibonacci limit of standard 64-bit longs.
 */
public class FibonacciStreamDemo {

    public static void main(String[] args) {
        System.out.println("=== First 50 Fibonacci Numbers via Stream API ===\n");

        AtomicInteger index = new AtomicInteger(1);

        Stream.iterate(
                new BigInteger[] { BigInteger.ZERO, BigInteger.ONE },
                pair -> new BigInteger[] { pair[1], pair[0].add(pair[1]) }
        )
        .limit(50)
        .map(pair -> pair[0])
        .forEach(fib -> {
            int current = index.getAndIncrement();
            System.out.printf("F(%2d) = %s%n", current, fib.toString());
        });

        System.out.println("\nSuccessfully computed first 50 Fibonacci numbers using functional Stream.iterate.");
    }
}
