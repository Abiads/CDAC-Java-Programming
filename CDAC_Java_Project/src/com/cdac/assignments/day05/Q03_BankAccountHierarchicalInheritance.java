package com.cdac.assignments.day05;

import java.util.Scanner;

// Superclass
class BankAccount {
    long accountNo;
    String accountHolderName;
    double balance;

    BankAccount(long accountNo, String accountHolderName, double balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount + " | Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount!");
        }
    }

    void displayAccountDetails() {
        System.out.println("Account Number : " + accountNo);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
    }
}

// Subclass 1 demonstrating Hierarchical Inheritance
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(long accountNo, String accountHolderName, double balance, double interestRate) {
        super(accountNo, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    double calculateInterest() {
        return (balance * interestRate) / 100;
    }

    void displaySavingsDetails() {
        System.out.println("--- Savings Account Details ---");
        displayAccountDetails();
        System.out.println("Interest Rate  : " + interestRate + "%");
        System.out.println("Annual Interest: ₹" + calculateInterest());
    }
}

// Subclass 2 demonstrating Hierarchical Inheritance
class CurrentAccount extends BankAccount {
    double overdraftLimit;

    CurrentAccount(long accountNo, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNo, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    void checkOverdraftLimit() {
        System.out.println("Available Overdraft Limit: ₹" + overdraftLimit);
    }

    void displayCurrentAccountDetails() {
        System.out.println("--- Current Account Details ---");
        displayAccountDetails();
        System.out.println("Overdraft Limit: ₹" + overdraftLimit);
        checkOverdraftLimit();
    }
}

public class Q03_BankAccountHierarchicalInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Enter Savings Account Details ===");
        System.out.print("Account Number: ");
        long sAccNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Account Holder Name: ");
        String sName = sc.nextLine();

        System.out.print("Initial Balance: ");
        double sBal = sc.nextDouble();

        System.out.print("Interest Rate (%): ");
        double sRate = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount(sAccNo, sName, sBal, sRate);
        System.out.println();
        sa.displaySavingsDetails();
        sa.deposit(1000);

        System.out.println("\n=== Enter Current Account Details ===");
        System.out.print("Account Number: ");
        long cAccNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Account Holder Name: ");
        String cName = sc.nextLine();

        System.out.print("Initial Balance: ");
        double cBal = sc.nextDouble();

        System.out.print("Overdraft Limit: ");
        double cLimit = sc.nextDouble();

        CurrentAccount ca = new CurrentAccount(cAccNo, cName, cBal, cLimit);
        System.out.println();
        ca.displayCurrentAccountDetails();
        ca.withdraw(2000);

        sc.close();
    }
}
