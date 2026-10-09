package com.cdac.assignments.day07;

import java.util.InputMismatchException;
import java.util.Scanner;

class ElectricityBill {
    int consumerNo;
    String consumerName;
    int unitsConsumed;
    double billAmount;

    ElectricityBill(int consumerNo, String consumerName, int unitsConsumed) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.unitsConsumed = unitsConsumed;
    }

    double calculateBill() {
        if (unitsConsumed < 0) {
            throw new IllegalArgumentException("Units consumed cannot be negative: " + unitsConsumed);
        }

        // Slab 1: Up to 100 units @ Rs. 3/unit
        // Slab 2: 101–200 units @ Rs. 5/unit
        // Slab 3: Above 200 units @ Rs. 8/unit
        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 3.0;
        } else if (unitsConsumed <= 200) {
            billAmount = (100 * 3.0) + ((unitsConsumed - 100) * 5.0);
        } else {
            billAmount = (100 * 3.0) + (100 * 5.0) + ((unitsConsumed - 200) * 8.0);
        }
        return billAmount;
    }

    void displayBill() {
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Consumer No    : " + consumerNo);
        System.out.println("Consumer Name  : " + consumerName);
        System.out.println("Units Consumed : " + unitsConsumed);
        System.out.println("Total Amount   : Rs. " + billAmount);
    }
}

public class Q03_ElectricityBillException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Consumer Number: ");
            int cNo = sc.nextInt();

            System.out.print("Enter Consumer Name: ");
            String cName = sc.next();

            System.out.print("Enter Units Consumed: ");
            int units = sc.nextInt();

            if (units < 0) {
                throw new IllegalArgumentException("Units consumed cannot be negative!");
            }

            ElectricityBill bill = new ElectricityBill(cNo, cName, units);
            bill.calculateBill();
            bill.displayBill();

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid numeric input entered. Please enter valid numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            System.out.println("Electricity bill processing completed.");
            sc.close();
        }
    }
}
