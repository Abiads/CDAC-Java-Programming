package com.cdac.assignments.day05;

class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    double calculateDiscount() {
        return price * 0.10;
    }

    void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }
}

class Electronics extends Product {
    String brand;
    int warranty;

    Electronics(int productId, String productName, double price, String brand, int warranty) {
        super(productId, productName, price);
        this.brand = brand;
        this.warranty = warranty;
    }

    double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    void displayElectronicsDetails() {
        displayProductDetails();
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warranty + " months");
        System.out.println("Final Price: " + calculateFinalPrice());
    }
}

class Clothing extends Product {
    String size;
    String material;

    Clothing(int productId, String productName, double price, String size, String material) {
        super(productId, productName, price);
        this.size = size;
        this.material = material;
    }

    double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    void displayClothingDetails() {
        displayProductDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
        System.out.println("Final Price: " + calculateFinalPrice());
    }
}

public class Q04_ProductHierarchicalInheritance {
    public static void main(String[] args) {
        System.out.println("--- Electronics ---");
        Electronics e = new Electronics(101, "Smart TV", 40000, "Samsung", 24);
        e.displayElectronicsDetails();

        System.out.println("\n--- Clothing ---");
        Clothing c = new Clothing(201, "Cotton Shirt", 1500, "XL", "Cotton");
        c.displayClothingDetails();
    }
}
