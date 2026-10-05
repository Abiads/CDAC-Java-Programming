package com.cdac.assignments.day01;

import java.util.Scanner;

public class Q01_ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int sum = a + b;
        int diff = a - b;
        int prod = a * b;
        int div = a / b;
        int rem = a % b;

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + diff);
        System.out.println("Multiplication: " + prod);
        System.out.println("Division: " + div);
        System.out.println("Remainder: " + rem);

        sc.close();
    }
}
