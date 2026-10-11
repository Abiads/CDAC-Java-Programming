/**
 * TOPIC: Hierarchical Inheritance & Method Overriding (10 Marks OOPs Question)
 * 
 * PROBLEM STATEMENT:
 * Create a superclass BankAccount with accountNo, accountHolder, and balance.
 * Implement deposit(), withdraw(), and calculateInterest().
 * 
 * Create two subclasses:
 * 1. SavingsAccount: adds interestRate, overrides calculateInterest().
 * 2. CurrentAccount: adds overdraftLimit, checks withdrawal limit against balance + overdraft.
 * 
 * Demonstrate runtime polymorphism / object creation in main().
 */

class BankAccount {
    int accountNo;
    String accountHolder;
    double balance;

    BankAccount(int accountNo, String accountHolder, double balance) {
        this.accountNo = accountNo;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs. " + amount + " | Current Balance: Rs. " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Rs. " + amount + " | Remaining Balance: Rs. " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal of Rs. " + amount);
        }
    }

    double calculateInterest() {
        return balance * 0.02; // General base interest 2%
    }

    void displayDetails() {
        System.out.println("Account No     : " + accountNo);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : Rs. " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNo, String accountHolder, double balance, double interestRate) {
        super(accountNo, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return (balance * interestRate) / 100.0;
    }

    void displaySavingsDetails() {
        displayDetails();
        System.out.println("Account Type   : Savings Account");
        System.out.println("Interest Rate  : " + interestRate + "%");
        System.out.println("Annual Interest: Rs. " + calculateInterest());
    }
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;

    CurrentAccount(int accountNo, String accountHolder, double balance, double overdraftLimit) {
        super(accountNo, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn Rs. " + amount + " (Overdraft Used) | Balance: Rs. " + balance);
        } else {
            System.out.println("Withdrawal of Rs. " + amount + " exceeds balance + overdraft limit!");
        }
    }

    void displayCurrentDetails() {
        displayDetails();
        System.out.println("Account Type   : Current Account");
        System.out.println("Overdraft Limit: Rs. " + overdraftLimit);
    }
}

public class Prob02_BankAccount_Hierarchical {
    public static void main(String[] args) {
        System.out.println("--- 1. SAVINGS ACCOUNT DEMO ---");
        SavingsAccount sa = new SavingsAccount(1001, "Amit Verma", 50000.0, 4.5);
        sa.deposit(10000.0);
        sa.displaySavingsDetails();

        System.out.println("\n--- 2. CURRENT ACCOUNT DEMO ---");
        CurrentAccount ca = new CurrentAccount(2001, "Priya Singh", 40000.0, 20000.0);
        ca.displayCurrentDetails();
        System.out.println("\nAttempting withdrawal of Rs. 55000 (Within Overdraft):");
        ca.withdraw(55000.0);

        System.out.println("\nAttempting withdrawal of Rs. 20000 (Exceeds Limit):");
        ca.withdraw(20000.0);
    }
}
