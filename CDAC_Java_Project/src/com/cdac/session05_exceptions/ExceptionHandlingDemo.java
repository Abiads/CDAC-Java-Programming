package com.cdac.session05_exceptions;

/**
 * Syllabus Session 5:
 * Exception Handling: try, catch, multiple catch, nested try,
 * finally, throw, throws, and Custom Exceptions.
 */
public class ExceptionHandlingDemo {

    // Custom Checked Exception
    public static class InsufficientBalanceException extends Exception {
        private final double shortfall;

        public InsufficientBalanceException(String message, double shortfall) {
            super(message);
            this.shortfall = shortfall;
        }

        public double getShortfall() {
            return shortfall;
        }
    }

    // Custom Unchecked / Runtime Exception
    public static class InvalidAmountException extends RuntimeException {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

    public static void processWithdrawal(double balance, double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero! Provided: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Transaction declined: Insufficient balance.", amount - balance);
        }
        System.out.printf("Withdrawal of Rs. %,.2f successful! Remaining balance: Rs. %,.2f%n", amount, balance - amount);
    }

    public static void main(String[] args) {
        System.out.println("=== CDAC Session 5: Exception Handling Architecture ===\n");

        double accountBalance = 15000.0;

        // 1. Handling Custom Checked Exception
        try {
            System.out.println("Attempting withdrawal of Rs. 20,000...");
            processWithdrawal(accountBalance, 20000.0);
        } catch (InsufficientBalanceException e) {
            System.err.println("[CHECKED EXCEPTION CAUGHT] " + e.getMessage());
            System.err.println("Shortfall amount: Rs. " + e.getShortfall());
        } finally {
            System.out.println("[FINALLY BLOCK] Cleanup or audit log recorded.");
        }

        // 2. Handling Multiple Catch Blocks & Unchecked Exception
        System.out.println("\nAttempting invalid operations...");
        try {
            int[] arr = {10, 20, 30};
            int divisor = 0;
            // Uncheck to test either:
            // int errorDiv = arr[0] / divisor; // ArithmeticException
            processWithdrawal(accountBalance, -500.0); // InvalidAmountException
        } catch (InvalidAmountException | ArithmeticException ex) {
            System.err.println("[MULTI-CATCH CAUGHT] " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[GENERIC EXCEPTION] " + ex.getMessage());
        }
    }
}
