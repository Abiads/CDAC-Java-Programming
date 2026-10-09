package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q04_SearchElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number to search: ");
        int search = sc.nextInt();

        int foundIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == search) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element found at index " + foundIndex);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
