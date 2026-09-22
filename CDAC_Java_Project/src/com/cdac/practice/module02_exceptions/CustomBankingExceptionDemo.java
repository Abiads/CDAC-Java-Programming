package com.cdac.practice.module02_exceptions;

/**
 * Checked exception for handling insufficient balance during withdrawal.
 */
class InsufficientBalanceException extends Exception {
    private final double attemptedAmount;
    private final double availableBalance;

    public InsufficientBalanceException(String message, double attemptedAmount, double availableBalance) {
        super(message);
        this.attemptedAmount = attemptedAmount;
        this.availableBalance = availableBalance;
    }

    public double getAttemptedAmount() {
        return attemptedAmount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }
}

/**
 * Unchecked exception for validating invalid input amounts (e.g., negative or zero).
 */
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class BankAccount {
    private final String accountId;
    private double balance;

    public BankAccount(String accountId, double initialBalance) {
        if (initialBalance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative: " + initialBalance);
        }
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be strictly greater than 0: " + amount);
        }
        balance += amount;
        System.out.printf("[%s] Successfully deposited ₹%.2f. New Balance: ₹%.2f%n", accountId, amount, balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be strictly greater than 0: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Transaction Failed: Requested amount exceeds available balance.",
                    amount, balance);
        }
        balance -= amount;
        System.out.printf("[%s] Successfully withdrew ₹%.2f. Remaining Balance: ₹%.2f%n", accountId, amount, balance);
    }
}

public class CustomBankingExceptionDemo {

    public static void main(String[] args) {
        System.out.println("=== Custom Banking Exception Handling Demo ===");

        BankAccount account = new BankAccount("AC-987654", 5000.0);
        System.out.printf("Account created with initial balance: ₹%.2f%n%n", account.getBalance());

        // Test 1: Valid transactions
        try {
            account.deposit(2500.0);
            account.withdraw(3000.0);
        } catch (InsufficientBalanceException | InvalidAmountException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        // Test 2: Unchecked Exception (Negative deposit)
        System.out.println("\n--- Testing InvalidAmountException (Unchecked) ---");
        try {
            account.deposit(-500.0);
        } catch (InvalidAmountException ex) {
            System.out.println("Caught Expected Exception: " + ex.getMessage());
        }

        // Test 3: Checked Exception (Insufficient Balance)
        System.out.println("\n--- Testing InsufficientBalanceException (Checked) ---");
        try {
            account.withdraw(10000.0);
        } catch (InsufficientBalanceException ex) {
            System.out.println("Caught Expected Exception: " + ex.getMessage());
            System.out.printf("  Attempted: ₹%.2f | Available: ₹%.2f | Deficit: ₹%.2f%n",
                    ex.getAttemptedAmount(), ex.getAvailableBalance(), (ex.getAttemptedAmount() - ex.getAvailableBalance()));
        }

        System.out.printf("%nFinal Account Balance: ₹%.2f%n", account.getBalance());
    }
}
