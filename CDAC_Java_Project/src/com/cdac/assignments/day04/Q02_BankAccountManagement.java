package com.cdac.assignments.day04;

public class Q02_BankAccountManagement {
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
