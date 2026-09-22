package com.cdac.session03_oop;

/**
 * Syllabus Sessions 3 & 4:
 * Encapsulation, Access Modifiers, Method Overloading, Constructors,
 * and Immutable Classes.
 */
public class EncapsulationAndConstructorsDemo {

    // Bank Account demonstrating Encapsulation
    public static class BankAccount {
        private final String accountNumber;
        private String holderName;
        private double balance;

        // Default / No-arg constructor
        public BankAccount() {
            this("AC-0000", "Unknown", 0.0);
        }

        // Parameterized Constructor
        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = Math.max(balance, 0.0);
        }

        // Method Overloading: deposit
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.printf("Deposited: Rs. %,.2f | New Balance: Rs. %,.2f%n", amount, balance);
            }
        }

        public void deposit(double amount, String note) {
            System.out.println("Note: " + note);
            deposit(amount);
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.printf("Withdrawn: Rs. %,.2f | New Balance: Rs. %,.2f%n", amount, balance);
                return true;
            }
            System.out.println("Withdrawal failed: Insufficient funds or invalid amount.");
            return false;
        }

        public String getAccountNumber() { return accountNumber; }
        public String getHolderName() { return holderName; }
        public double getBalance() { return balance; }
    }

    // Immutable Class Pattern
    public static final class ImmutableCoordinate {
        private final double latitude;
        private final double longitude;

        public ImmutableCoordinate(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() { return latitude; }
        public double getLongitude() { return longitude; }

        @Override
        public String toString() {
            return "(" + latitude + ", " + longitude + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== CDAC Sessions 3 & 4: Encapsulation & Constructors ===");

        BankAccount acc = new BankAccount("AC-1001", "Pooja Deshmukh", 25000.0);
        System.out.println("Account Holder: " + acc.getHolderName());
        acc.deposit(5000.0);
        acc.deposit(10000.0, "Salary credit");
        acc.withdraw(8000.0);

        ImmutableCoordinate pune = new ImmutableCoordinate(18.5204, 73.8567);
        System.out.println("Pune GPS Coordinate: " + pune);
    }
}
