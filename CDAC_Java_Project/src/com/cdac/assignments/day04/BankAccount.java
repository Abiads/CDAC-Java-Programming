package com.cdac.assignments.day04;

import java.util.Scanner;

public class BankAccount {
    long accountNumber;
    String customerName;
    double balance;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLong();
        System.out.print("Enter Customer Name: ");
        customerName = sc.next();
        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();
        sc.close();
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Successfully deposited: ₹" + amount);
        System.out.println("Current Balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance! Withdrawal failed.");
        }
    }

    public void display() {
        System.out.println("\n--- Bank Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Current Balance: ₹" + balance);
    }
}
