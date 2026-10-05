package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Assignment 4 - Problem 2: Bank Account Management
 *
 * Requirements:
 * - Data members: Account Number, Customer Name, Balance
 * - Methods:
 *     read() - to read account details
 *     deposit() / deposit(double amount) - to deposit an amount into the account
 *     withdraw() / withdraw(double amount) - to withdraw an amount if sufficient balance is available
 *     display() - to display account details and current balance
 * - Create an object and perform one deposit and one withdrawal operation.
 */
public class BankAccount {

    private long accountNumber;
    private String customerName;
    private double balance;

    // Default Constructor
    public BankAccount() {
    }

    // Parameterized Constructor
    public BankAccount(long accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = Math.max(balance, 0.0);
    }

    // Interactive read method using Scanner
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Enter Account Details -----");
        System.out.print("Enter Account Number: ");
        this.accountNumber = sc.nextLong();
        sc.nextLine(); // consume newline

        System.out.print("Enter Customer Name: ");
        this.customerName = sc.nextLine();

        System.out.print("Enter Initial Balance (₹): ");
        this.balance = sc.nextDouble();
    }

    // Programmatic read method
    public void read(long accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = Math.max(balance, 0.0);
    }

    // Deposit method with amount parameter
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("[SUCCESS] Deposited ₹%.2f. Updated Balance: ₹%.2f%n", amount, this.balance);
        } else {
            System.out.println("[ERROR] Invalid deposit amount: must be greater than zero.");
        }
    }

    // Interactive deposit method
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit (₹): ");
        double amount = sc.nextDouble();
        deposit(amount);
    }

    // Withdraw method with amount parameter
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[ERROR] Invalid withdrawal amount: must be greater than zero.");
            return false;
        }
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.printf("[SUCCESS] Withdrawn ₹%.2f. Updated Balance: ₹%.2f%n", amount, this.balance);
            return true;
        } else {
            System.out.printf("[FAILED] Insufficient balance! Attempted withdrawal: ₹%.2f, Available: ₹%.2f%n",
                    amount, this.balance);
            return false;
        }
    }

    // Interactive withdraw method
    public boolean withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw (₹): ");
        double amount = sc.nextDouble();
        return withdraw(amount);
    }

    // Display account details and current balance
    public void display() {
        System.out.println("\n========== Bank Account Details ==========");
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Customer Name   : " + customerName);
        System.out.printf("Current Balance : ₹%.2f%n", balance);
        System.out.println("==========================================");
    }

    // Getters and Setters
    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getBalance() { return balance; }

    // Standalone runner for testing
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.read(100200300400L, "Priya Nair", 15000.0);
        acc.display();
        acc.deposit(5000.0);
        acc.withdraw(3500.0);
        acc.display();
    }
}
