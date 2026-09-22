package com.cdac.assignments.day01;

import java.util.Scanner;

/**
 * Question 1: Arithmetic Operations
 * Problem: Declare two integer variables and perform addition, subtraction,
 * multiplication, division, and remainder operations. Display all results.
 */
public class Q01_ArithmeticOperations {

    public static void main(String[] args) {
        System.out.println("=== Question 1: Arithmetic Operations ===");

        int num1 = 20;
        int num2 = 6;

        // Interactive fallback if user supplies input via console
        System.out.println("Using default values: num1 = " + num1 + ", num2 = " + num2);

        int sum = num1 + num2;
        int diff = num1 - num2;
        int product = num1 * num2;
        int quotient = num1 / num2;
        int remainder = num1 % num2;

        System.out.println("Addition       : " + num1 + " + " + num2 + " = " + sum);
        System.out.println("Subtraction    : " + num1 + " - " + num2 + " = " + diff);
        System.out.println("Multiplication : " + num1 + " * " + num2 + " = " + product);
        System.out.println("Division       : " + num1 + " / " + num2 + " = " + quotient);
        System.out.println("Remainder      : " + num1 + " % " + num2 + " = " + remainder);
    }
}
