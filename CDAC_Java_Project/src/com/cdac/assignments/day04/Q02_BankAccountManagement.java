package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Runner class for Assignment 4 - Problem 2: Bank Account Management
 *
 * Requirements:
 * "Create an object and perform one deposit and one withdrawal operation."
 */
public class Q02_BankAccountManagement {

    public static void main(String[] args) {
        System.out.println("=== Day 04 - Assignment 2: Bank Account Management ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Run with interactive user input? (y/n, default n for demo): ");
        String choice = sc.hasNextLine() ? sc.nextLine().trim() : "n";

        BankAccount account = new BankAccount();

        if (choice.equalsIgnoreCase("y")) {
            account.read();
            account.display();

            System.out.println("\n--- Performing Deposit Operation ---");
            account.deposit();

            System.out.println("\n--- Performing Withdrawal Operation ---");
            account.withdraw();
        } else {
            System.out.println("Running with sample data...");
            account.read(987654321012L, "Rahul Dravid", 25000.0);
            account.display();

            System.out.println("\n--- Step 1: Performing One Deposit Operation (₹7,500) ---");
            account.deposit(7500.0);

            System.out.println("\n--- Step 2: Performing One Withdrawal Operation (₹12,000) ---");
            account.withdraw(12000.0);

            System.out.println("\n--- Step 3: Demonstrating Overdraft Rejection (₹50,000) ---");
            account.withdraw(50000.0);
        }

        System.out.println("\n--- Final Account Status ---");
        account.display();
    }
}
