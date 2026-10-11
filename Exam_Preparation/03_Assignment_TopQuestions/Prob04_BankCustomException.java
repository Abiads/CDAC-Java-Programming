import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: Custom User-Defined Exception (10 Marks Target)
 * Problem 4: Bank Account with InsufficientFundsException
 * 
 * Demonstrates:
 * 1. Extending Exception to create InsufficientFundsException
 * 2. throw keyword to raise custom exception
 * 3. throws keyword in method signature
 * 4. try-catch-finally block to handle exceptions gracefully
 * ============================================================================
 */

// Custom Checked Exception
class InsufficientFundsException extends Exception {
    private double deficit;

    public InsufficientFundsException(double deficit) {
        super("Transaction Failed: Insufficient balance! Short by Rs. " + deficit);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}

class BankAccountWithException {
    private int accNo;
    private String holderName;
    private double balance;

    public BankAccountWithException(int accNo, String holderName, double balance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs. " + amount + " | New Balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method declaring that it throws InsufficientFundsException
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException(deficit);
        }
        balance -= amount;
        System.out.println("Withdrawn Rs. " + amount + " | Remaining Balance: Rs. " + balance);
    }

    public void displayAccount() {
        System.out.println("Acc No: " + accNo + " | Holder: " + holderName + " | Balance: Rs." + balance);
    }
}

public class Prob04_BankCustomException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccountWithException account = new BankAccountWithException(5001, "Aditi Sharma", 5000.0);

        System.out.println("=================================================");
        System.out.println("    BANK ACCOUNT WITH USER-DEFINED EXCEPTION     ");
        System.out.println("=================================================");
        account.displayAccount();

        System.out.println("\n--- Performing Valid Deposit ---");
        account.deposit(2000.0);

        System.out.println("\n--- Testing Withdrawal with Exception Handling ---");
        System.out.print("Enter amount to withdraw: ");
        if (sc.hasNextDouble()) {
            double amount = sc.nextDouble();
            try {
                account.withdraw(amount);
                System.out.println("Withdrawal processed successfully!");
            } catch (InsufficientFundsException e) {
                System.err.println("\n[CUSTOM EXCEPTION CAUGHT]: " + e.getMessage());
                System.err.println("Shortage amount needed: Rs. " + e.getDeficit());
            } finally {
                System.out.println("\n[FINALLY BLOCK]: Updating transaction audit log & closing resources.");
                account.displayAccount();
            }
        }

        sc.close();
    }
}
