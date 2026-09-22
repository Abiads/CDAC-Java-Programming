package com.cdac.practice.module01_oop;

import java.util.Scanner;

/**
 * Module 1: OOP & String Practice
 * Demonstrates manual pointer-based palindrome check vs StringBuilder.reverse().
 */
public class StringPalindromeDemo {

    // Method 1: Two-pointer manual character comparison (ignoring case and whitespace)
    public static boolean isPalindromeManual(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 2: Using StringBuilder.reverse()
    public static boolean isPalindromeStringBuilder(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== String Palindrome Checker ===");
        System.out.print("Enter a string to test: ");
        String input = sc.nextLine();

        boolean resManual = isPalindromeManual(input);
        boolean resBuilder = isPalindromeStringBuilder(input);

        System.out.println("\nResults:");
        System.out.println("Input                  : \"" + input + "\"");
        System.out.println("Manual Pointer Check   : " + (resManual ? "PALINDROME" : "NOT A PALINDROME"));
        System.out.println("StringBuilder Check    : " + (resBuilder ? "PALINDROME" : "NOT A PALINDROME"));
        System.out.println("Both methods agree     : " + (resManual == resBuilder));

        sc.close();
    }
}
