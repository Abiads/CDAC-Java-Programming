package com.cdac.assignments.day04;

public class Q03_ProductBilling {
    public static void main(String[] args) {
        Product p = new Product();
        p.read();
        p.calculateBill();
        p.display();
    }
}
