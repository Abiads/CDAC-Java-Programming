package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Assignment 4 - Problem 3: Product Billing
 *
 * Requirements:
 * - Data members: Product ID, Product Name, Price, Quantity
 * - Methods:
 *     read() - to read product details
 *     calculateBill() - to calculate total amount (Total Amount = Price × Quantity)
 *     display() - to display product details and total bill amount
 * - Create an object of the class and display the bill.
 */
public class Product {

    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private double totalAmount;

    // Default Constructor
    public Product() {
    }

    // Parameterized Constructor
    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = Math.max(price, 0.0);
        this.quantity = Math.max(quantity, 0);
        this.totalAmount = calculateBill();
    }

    // Interactive read method using Scanner
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Enter Product Details -----");
        System.out.print("Enter Product ID: ");
        this.productId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Product Name: ");
        this.productName = sc.nextLine();

        System.out.print("Enter Unit Price (₹): ");
        this.price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        this.quantity = sc.nextInt();

        this.totalAmount = calculateBill();
    }

    // Programmatic read method
    public void read(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = Math.max(price, 0.0);
        this.quantity = Math.max(quantity, 0);
        this.totalAmount = calculateBill();
    }

    // Method to calculate total bill amount
    public double calculateBill() {
        this.totalAmount = this.price * this.quantity;
        return this.totalAmount;
    }

    // Method to display product details and total bill amount
    public void display() {
        System.out.println("\n========== Product Invoice ==========");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.printf("Unit Price   : ₹%.2f%n", price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("-------------------------------------");
        System.out.printf("Total Bill   : ₹%.2f%n", totalAmount);
        System.out.println("=====================================");
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalAmount() { return totalAmount; }

    // Standalone runner for testing
    public static void main(String[] args) {
        Product p = new Product();
        p.read(501, "Logitech MX Master 3S Wireless Mouse", 7999.0, 3);
        p.display();
    }
}
