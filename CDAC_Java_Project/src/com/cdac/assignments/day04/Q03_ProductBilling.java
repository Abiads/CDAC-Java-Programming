package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Runner class for Assignment 4 - Problem 3: Product Billing
 *
 * Requirements:
 * "Create an object of the class and display the bill."
 */
public class Q03_ProductBilling {

    public static void main(String[] args) {
        System.out.println("=== Day 04 - Assignment 3: Product Billing ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Run with interactive user input? (y/n, default n for demo): ");
        String choice = sc.hasNextLine() ? sc.nextLine().trim() : "n";

        Product product = new Product();

        if (choice.equalsIgnoreCase("y")) {
            product.read();
        } else {
            System.out.println("Running with sample data...");
            product.read(2042, "Mechanical Keyboard (Cherry MX)", 4499.0, 2);
        }

        product.calculateBill();
        product.display();
    }
}
