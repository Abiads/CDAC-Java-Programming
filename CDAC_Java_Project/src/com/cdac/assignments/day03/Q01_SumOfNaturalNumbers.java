package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q01_SumOfNaturalNumbers {

    public static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter positive integer N: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer greater than zero.");
        } else {
            long loopSum = calculateSum(n);
            long formulaSum = (long) n * (n + 1) / 2;

            System.out.println("Sum using loop    : " + loopSum);
            System.out.println("Sum using formula : " + formulaSum);
            System.out.println("Match confirmed   : " + (loopSum == formulaSum));
        }

        sc.close();
    }
}
