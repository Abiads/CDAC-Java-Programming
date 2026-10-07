import java.util.Scanner;

// Superclass
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
        return price * 0.10; // 10% standard discount
    }

    void displayProductDetails() {
        System.out.println("Product ID     : " + productId);
        System.out.println("Product Name   : " + productName);
        System.out.println("Base Price     : ₹" + price);
        System.out.println("Discount (10%) : ₹" + calculateDiscount());
    }
}

// Subclass 1 demonstrating Hierarchical Inheritance
class Electronics extends Product {
    String brand;
    int warranty; // in months

    Electronics(int productId, String productName, double price, String brand, int warranty) {
        super(productId, productName, price);
        this.brand = brand;
        this.warranty = warranty;
    }

    double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    void displayElectronicsDetails() {
        System.out.println("--- Electronics Product Details ---");
        displayProductDetails();
        System.out.println("Brand          : " + brand);
        System.out.println("Warranty       : " + warranty + " months");
        System.out.println("Final Price    : ₹" + calculateFinalPrice());
    }
}

// Subclass 2 demonstrating Hierarchical Inheritance
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
        System.out.println("--- Clothing Product Details ---");
        displayProductDetails();
        System.out.println("Size           : " + size);
        System.out.println("Material       : " + material);
        System.out.println("Final Price    : ₹" + calculateFinalPrice());
    }
}

public class Q04_ProductHierarchicalInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Enter Electronics Product Details ===");
        System.out.print("Product ID: ");
        int eId = sc.nextInt();
        sc.nextLine();

        System.out.print("Product Name: ");
        String eName = sc.nextLine();

        System.out.print("Price: ");
        double ePrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Brand: ");
        String eBrand = sc.nextLine();

        System.out.print("Warranty (in months): ");
        int eWarranty = sc.nextInt();

        Electronics ele = new Electronics(eId, eName, ePrice, eBrand, eWarranty);
        System.out.println();
        ele.displayElectronicsDetails();

        System.out.println("\n=== Enter Clothing Product Details ===");
        System.out.print("Product ID: ");
        int cId = sc.nextInt();
        sc.nextLine();

        System.out.print("Product Name: ");
        String cName = sc.nextLine();

        System.out.print("Price: ");
        double cPrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Size (e.g., M, L, XL): ");
        String cSize = sc.nextLine();

        System.out.print("Material (e.g., Cotton): ");
        String cMaterial = sc.nextLine();

        Clothing clo = new Clothing(cId, cName, cPrice, cSize, cMaterial);
        System.out.println();
        clo.displayClothingDetails();

        sc.close();
    }
}
