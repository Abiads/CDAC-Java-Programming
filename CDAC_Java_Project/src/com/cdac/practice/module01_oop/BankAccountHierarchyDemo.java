package com.cdac.practice.module01_oop;

/**
 * Module 1: OOP & Inheritance Practice
 * Demonstrates abstract classes, encapsulation, method overriding, and runtime polymorphism.
 */
abstract class Account {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    public void displayAccountInfo() {
        System.out.printf("[%s] Account: %s | Holder: %s | Balance: ₹%.2f%n",
                getClass().getSimpleName(), accountNumber, holderName, balance);
    }
}

class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Savings [%s]: Deposited ₹%.2f. New Balance: ₹%.2f%n", getAccountNumber(), amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amount < MIN_BALANCE) {
            System.out.printf("Savings [%s]: Withdrawal of ₹%.2f DENIED! Minimum balance of ₹%.2f must be maintained.%n",
                    getAccountNumber(), amount, MIN_BALANCE);
            return false;
        }
        balance -= amount;
        System.out.printf("Savings [%s]: Withdrew ₹%.2f. Remaining Balance: ₹%.2f%n", getAccountNumber(), amount, balance);
        return true;
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Current [%s]: Deposited ₹%.2f. New Balance: ₹%.2f%n", getAccountNumber(), amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf("Current [%s]: Withdrawal of ₹%.2f DENIED! Exceeds overdraft limit of ₹%.2f.%n",
                    getAccountNumber(), amount, overdraftLimit);
            return false;
        }
        balance -= amount;
        System.out.printf("Current [%s]: Withdrew ₹%.2f. Remaining Balance: ₹%.2f (Overdraft used: ₹%.2f)%n",
                getAccountNumber(), amount, balance, balance < 0 ? -balance : 0);
        return true;
    }
}

public class BankAccountHierarchyDemo {

    public static void main(String[] args) {
        System.out.println("=== Bank Account Hierarchy & Dynamic Method Dispatch ===");

        Account[] accounts = new Account[] {
            new SavingsAccount("SA-101", "Alice Sharma", 5000.0),
            new CurrentAccount("CA-202", "Apex Tech Corp", 15000.0, 10000.0)
        };

        for (Account acc : accounts) {
            acc.displayAccountInfo();
            acc.deposit(2000.0);
            acc.withdraw(6000.0); // Savings should warn or adjust, Current will handle
            acc.withdraw(12000.0); // Savings fails minimum balance check; Current uses overdraft
            System.out.println("--------------------------------------------------");
        }
    }
}
