package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q07_ArrayMinMax {

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid array size.");
        } else {
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                System.out.print("Element [" + i + "]: ");
                arr[i] = sc.nextInt();
            }

            int min = findMin(arr);
            int max = findMax(arr);

            System.out.println("\nMinimum Element: " + min);
            System.out.println("Maximum Element: " + max);
        }

        sc.close();
    }
}
