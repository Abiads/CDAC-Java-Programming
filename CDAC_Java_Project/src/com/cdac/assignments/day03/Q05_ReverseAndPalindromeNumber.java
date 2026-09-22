package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q05_ReverseAndPalindromeNumber {

    public static int reverseNumber(int n) {
        int rev = 0;
        int temp = Math.abs(n);

        while (temp > 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp /= 10;
        }

        return (n < 0) ? -rev : rev;
    }

    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false; // Negative numbers are not palindromes due to negative sign
        }
        return n == reverseNumber(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        int reversed = reverseNumber(num);
        boolean palindrome = isPalindrome(num);

        System.out.println("Original Number : " + num);
        System.out.println("Reversed Number : " + reversed);
        System.out.println("Is Palindrome?  : " + (palindrome ? "YES" : "NO"));

        sc.close();
    }
}
