package com.cdac.assignments.day01;

/**
 * Question 8: Largest of Two Numbers
 * Problem: Accept two numbers and find the larger number using if-else.
 * If both numbers are equal, display an appropriate message.
 */
public class Q08_LargestOfTwo {

    public static void findLargest(int a, int b) {
        System.out.print("Comparing " + a + " and " + b + " -> ");
        if (a > b) {
            System.out.println(a + " is greater than " + b);
        } else if (b > a) {
            System.out.println(b + " is greater than " + a);
        } else {
            System.out.println("Both numbers are EQUAL (" + a + " == " + b + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 8: Largest of Two Numbers ===");

        findLargest(85, 42);
        findLargest(30, 99);
        findLargest(50, 50);
    }
}
