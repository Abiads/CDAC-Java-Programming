import java.util.Scanner;

class BankAccount {
    long accountNumber;
    String customerName;
    double balance;

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLong();
        System.out.print("Enter Customer Name: ");
        customerName = sc.next();
        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Successfully deposited: ₹" + amount);
        System.out.println("Current Balance: ₹" + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance! Withdrawal failed.");
        }
    }

    void display() {
        System.out.println("\n--- Bank Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class Q02_BankAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.read();
        acc.display();

        System.out.println("\nPerforming deposit operation:");
        acc.deposit(2000);

        System.out.println("\nPerforming withdrawal operation:");
        acc.withdraw(1500);

        acc.display();
    }
}
