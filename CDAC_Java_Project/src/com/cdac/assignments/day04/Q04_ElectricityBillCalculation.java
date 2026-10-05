package com.cdac.assignments.day04;

public class Q04_ElectricityBillCalculation {
    public static void main(String[] args) {
        ElectricityBill eb = new ElectricityBill();
        eb.read();
        eb.calculateBill();
        eb.display();
    }
}
