package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Runner class for Assignment 4 - Problem 4: Electricity Bill Calculation
 *
 * Requirements:
 * "Create an object and display the electricity bill."
 */
public class Q04_ElectricityBillCalculation {

    public static void main(String[] args) {
        System.out.println("=== Day 04 - Assignment 4: Electricity Bill Calculation ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Run with interactive user input? (y/n, default n for demo): ");
        String choice = sc.hasNextLine() ? sc.nextLine().trim() : "n";

        ElectricityBill bill = new ElectricityBill();

        if (choice.equalsIgnoreCase("y")) {
            bill.read();
        } else {
            System.out.println("Running with sample data (250 units):");
            System.out.println("Tariff: 0-100 @ ₹2, 101-200 @ ₹3, >200 @ ₹5");
            bill.read(9012345678L, "Ananya Chatterjee", 250);
        }

        bill.calculateBill();
        bill.display();
    }
}
