package com.cdac.assignments.day01;

/**
 * Question 7: Positive, Negative or Zero
 * Problem: Accept an integer and check whether it is positive, negative, or zero using if and if-else.
 */
public class Q07_PositiveNegativeZero {

    public static void checkSign(int number) {
        if (number > 0) {
            System.out.println(number + " is POSITIVE.");
        } else if (number < 0) {
            System.out.println(number + " is NEGATIVE.");
        } else {
            System.out.println(number + " is ZERO.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 7: Positive, Negative, or Zero Checker ===");

        checkSign(45);
        checkSign(-19);
        checkSign(0);
    }
}
