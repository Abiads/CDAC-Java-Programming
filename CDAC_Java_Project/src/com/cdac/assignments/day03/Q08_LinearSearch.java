package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q08_LinearSearch {

    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return 0-based index
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();

        int index = search(arr, target);

        if (index != -1) {
            System.out.println("Target " + target + " FOUND at index: " + index + " (Position: " + (index + 1) + ")");
        } else {
            System.out.println("Target " + target + " NOT FOUND in the array.");
        }

        sc.close();
    }
}
