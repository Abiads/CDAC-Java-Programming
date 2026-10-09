class BankAccount {
    int accountNo;
    String accountHolderName;
    double balance;

    BankAccount(int accountNo, String accountHolderName, double balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // General implementation in superclass
    double calculateInterest() {
        return balance * 0.02; // General base interest 2%
    }

    void displayAccountDetails() {
        System.out.println("Account No     : " + accountNo);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : Rs. " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNo, String accountHolderName, double balance, double interestRate) {
        super(accountNo, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return (balance * interestRate) / 100.0;
    }
}

class CurrentAccount extends BankAccount {
    double interestRate;

    CurrentAccount(int accountNo, String accountHolderName, double balance, double interestRate) {
        super(accountNo, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return (balance * interestRate) / 100.0;
    }
}

public class Q03_BankAccountInterestOverriding {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(1001, "Amit Sharma", 50000.0, 4.5);
        CurrentAccount ca = new CurrentAccount(2001, "Neha Verma", 150000.0, 1.5);

        System.out.println("--- Savings Account ---");
        sa.displayAccountDetails();
        System.out.println("Interest Rate  : " + sa.interestRate + "%");
        System.out.println("Interest Amount: Rs. " + sa.calculateInterest());

        System.out.println("\n--- Current Account ---");
        ca.displayAccountDetails();
        System.out.println("Interest Rate  : " + ca.interestRate + "%");
        System.out.println("Interest Amount: Rs. " + ca.calculateInterest());
    }
}
