package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q02_FactorialCalculation {

    public static long calculateFactorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers.");
        } else if (n > 20) {
            System.out.println("Warning: For n > 20, 64-bit long will overflow. Please choose n <= 20.");
        } else {
            long result = calculateFactorial(n);
            System.out.println(n + "! = " + result);
        }

        sc.close();
    }
}
