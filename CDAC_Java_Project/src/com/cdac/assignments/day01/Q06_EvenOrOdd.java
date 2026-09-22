package com.cdac.assignments.day01;

/**
 * Question 6: Even or Odd
 * Problem: Accept an integer and check whether the number is even or odd using if-else.
 */
public class Q06_EvenOrOdd {

    public static void checkEvenOrOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is an EVEN number.");
        } else {
            System.out.println(number + " is an ODD number.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 6: Even or Odd Checker ===");

        int test1 = 28;
        int test2 = 17;
        int test3 = 0;

        checkEvenOrOdd(test1);
        checkEvenOrOdd(test2);
        checkEvenOrOdd(test3);
    }
}
