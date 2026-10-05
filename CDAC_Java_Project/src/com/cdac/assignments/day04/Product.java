package com.cdac.assignments.day04;

import java.util.Scanner;

public class Product {
    int productId;
    String productName;
    double price;
    int quantity;
    double totalAmount;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        productId = sc.nextInt();
        System.out.print("Enter Product Name: ");
        productName = sc.next();
        System.out.print("Enter Price: ");
        price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        quantity = sc.nextInt();
        sc.close();
    }

    public void calculateBill() {
        totalAmount = price * quantity;
    }

    public void display() {
        System.out.println("\n--- Product Invoice ---");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : ₹" + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total Amount : ₹" + totalAmount);
    }
}
