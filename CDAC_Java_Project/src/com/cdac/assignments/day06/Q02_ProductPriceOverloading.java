package com.cdac.assignments.day06;

class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Method 1: Price of one product
    double calculatePrice() {
        return price;
    }

    // Method 2: Total price based on quantity
    double calculatePrice(int quantity) {
        return price * quantity;
    }

    // Method 3: Total price after discount percentage
    double calculatePrice(int quantity, double discount) {
        double total = price * quantity;
        double discountAmount = total * (discount / 100.0);
        return total - discountAmount;
    }

    void displayProductDetails() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Unit Price   : Rs. " + price);
    }
}

public class Q02_ProductPriceOverloading {
    public static void main(String[] args) {
        Product p = new Product(501, "Wireless Mouse", 800.0);

        System.out.println("--- Product Details ---");
        p.displayProductDetails();

        System.out.println("\n--- Overloaded Price Calculations ---");
        // 1. Single product price
        System.out.println("Price (Single item)                  : Rs. " + p.calculatePrice());

        // 2. Price for multiple items (quantity = 5)
        System.out.println("Price for 5 items                    : Rs. " + p.calculatePrice(5));

        // 3. Price for multiple items with discount (quantity = 5, 10% discount)
        System.out.println("Price for 5 items with 10% discount  : Rs. " + p.calculatePrice(5, 10.0));
    }
}
