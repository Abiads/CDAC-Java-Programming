package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q06_ArraySumAndAverage {

    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    public static double calculateAverage(int[] arr) {
        if (arr.length == 0) return 0.0;
        return (double) calculateSum(arr) / arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be greater than 0.");
        } else {
            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                System.out.print("Element [" + i + "]: ");
                arr[i] = sc.nextInt();
            }

            int sum = calculateSum(arr);
            double avg = calculateAverage(arr);

            System.out.println("\n--- Summary ---");
            System.out.println("Total Elements : " + n);
            System.out.println("Sum of Elements: " + sum);
            System.out.printf("Average Value  : %.2f%n", avg);
        }

        sc.close();
    }
}
