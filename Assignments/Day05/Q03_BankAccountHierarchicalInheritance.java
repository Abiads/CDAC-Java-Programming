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
        balance = balance + amount;
        System.out.println("Deposited: " + amount + ", Current Balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displayAccountDetails() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

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
        displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Interest Amount: " + calculateInterest());
    }
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;

    CurrentAccount(long accountNo, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNo, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    void checkOverdraftLimit() {
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }

    void displayCurrentAccountDetails() {
        displayAccountDetails();
        checkOverdraftLimit();
    }
}

public class Q03_BankAccountHierarchicalInheritance {
    public static void main(String[] args) {
        System.out.println("--- Savings Account ---");
        SavingsAccount sa = new SavingsAccount(1001, "Amit Kumar", 25000, 4.5);
        sa.displaySavingsDetails();
        sa.deposit(5000);

        System.out.println("\n--- Current Account ---");
        CurrentAccount ca = new CurrentAccount(2001, "Vikram Enterprises", 50000, 20000);
        ca.displayCurrentAccountDetails();
        ca.withdraw(15000);
    }
}
