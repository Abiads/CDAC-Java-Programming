package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Assignment 4 - Problem 4: Electricity Bill Calculation (Object-Oriented)
 *
 * Requirements:
 * - Data members: Consumer Number, Consumer Name, Number of Units
 * - Methods:
 *     read() - to read consumer details and units consumed
 *     calculateBill() - to calculate electricity bill using tariff:
 *         First 100 units  → ₹2 per unit
 *         Next 100 units   → ₹3 per unit
 *         Above 200 units  → ₹5 per unit
 *     display() - to display consumer details and bill amount
 * - Create an object and display the electricity bill.
 */
public class ElectricityBill {

    private long consumerNumber;
    private String consumerName;
    private int units;
    private double billAmount;

    // Default Constructor
    public ElectricityBill() {
    }

    // Parameterized Constructor
    public ElectricityBill(long consumerNumber, String consumerName, int units) {
        this.consumerNumber = consumerNumber;
        this.consumerName = consumerName;
        this.units = Math.max(units, 0);
        this.billAmount = calculateBill();
    }

    // Interactive read method using Scanner
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Enter Consumer Details -----");
        System.out.print("Enter Consumer Number: ");
        this.consumerNumber = sc.nextLong();
        sc.nextLine(); // consume newline

        System.out.print("Enter Consumer Name: ");
        this.consumerName = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        this.units = sc.nextInt();

        this.billAmount = calculateBill();
    }

    // Programmatic read method
    public void read(long consumerNumber, String consumerName, int units) {
        this.consumerNumber = consumerNumber;
        this.consumerName = consumerName;
        this.units = Math.max(units, 0);
        this.billAmount = calculateBill();
    }

    // Method to calculate electricity bill according to the tiered tariff
    public double calculateBill() {
        if (units <= 0) {
            this.billAmount = 0.0;
        } else if (units <= 100) {
            this.billAmount = units * 2.0;
        } else if (units <= 200) {
            this.billAmount = (100 * 2.0) + ((units - 100) * 3.0);
        } else {
            this.billAmount = (100 * 2.0) + (100 * 3.0) + ((units - 200) * 5.0);
        }
        return this.billAmount;
    }

    // Method to display consumer details and bill amount
    public void display() {
        System.out.println("\n========== Electricity Bill ==========");
        System.out.println("Consumer Number : " + consumerNumber);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Units Consumed  : " + units);
        System.out.println("--------------------------------------");
        System.out.printf("Bill Amount     : ₹%.2f%n", billAmount);
        System.out.println("======================================");
    }

    // Getters and Setters
    public long getConsumerNumber() { return consumerNumber; }
    public void setConsumerNumber(long consumerNumber) { this.consumerNumber = consumerNumber; }

    public String getConsumerName() { return consumerName; }
    public void setConsumerName(String consumerName) { this.consumerName = consumerName; }

    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }

    public double getBillAmount() { return billAmount; }

    // Standalone runner for testing
    public static void main(String[] args) {
        ElectricityBill bill = new ElectricityBill();
        bill.read(8831002241L, "Sunil Gavaskar", 250);
        bill.display();
    }
}
