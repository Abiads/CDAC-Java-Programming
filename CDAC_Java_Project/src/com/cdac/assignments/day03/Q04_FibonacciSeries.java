package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q04_FibonacciSeries {

    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive count.");
            return;
        }

        long first = 0, second = 1;
        System.out.print("Fibonacci Series (" + n + " terms): ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + (i < n ? ", " : ""));
            long next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms N: ");
        int n = sc.nextInt();

        printFibonacci(n);

        sc.close();
    }
}
