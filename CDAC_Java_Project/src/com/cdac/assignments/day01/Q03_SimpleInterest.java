package com.cdac.assignments.day01;

/**
 * Question 3: Simple Interest Calculation
 * Problem: Accept principal amount, rate of interest and time using variables
 * and calculate simple interest and total amount.
 * Formulas:
 *   Simple Interest = (P * R * T) / 100
 *   Amount = P + Simple Interest
 */
public class Q03_SimpleInterest {

    public static void main(String[] args) {
        System.out.println("=== Question 3: Simple Interest Calculation ===");

        double principal = 50000.0; // In INR
        double rate = 7.5;          // Annual rate in %
        double timeYears = 3.0;     // Time in years

        double simpleInterest = (principal * rate * timeYears) / 100.0;
        double totalAmount = principal + simpleInterest;

        System.out.printf("Principal Amount (P) : Rs. %,.2f%n", principal);
        System.out.printf("Rate of Interest (R) : %.2f%%%n", rate);
        System.out.printf("Time in Years    (T) : %.1f years%n", timeYears);
        System.out.println("----------------------------------------------");
        System.out.printf("Simple Interest      : Rs. %,.2f%n", simpleInterest);
        System.out.printf("Total Payable Amount : Rs. %,.2f%n", totalAmount);
    }
}
