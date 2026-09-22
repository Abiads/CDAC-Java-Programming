package com.cdac.assignments.day02;

import java.util.Scanner;

public class Q01_ElectricityBill {

    public static double calculateBill(int units) {
        double bill = 0;

        if (units <= 100) {
            bill = units * 2.0;
        } else if (units <= 200) {
            bill = 100 * 2.0 + (units - 100) * 3.0;
        } else if (units <= 300) {
            bill = 100 * 2.0 + 100 * 3.0 + (units - 200) * 5.0;
        } else {
            bill = 100 * 2.0 + 100 * 3.0 + 100 * 5.0 + (units - 300) * 7.0;
        }

        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        double bill = calculateBill(units);

        System.out.println("Units consumed : " + units);
        System.out.printf("Electricity Bill : ₹%.2f%n", bill);

        sc.close();
    }
}
