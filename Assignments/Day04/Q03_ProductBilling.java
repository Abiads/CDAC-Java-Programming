import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;
    int quantity;
    double totalAmount;

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        productId = sc.nextInt();
        System.out.print("Enter Product Name: ");
        productName = sc.next();
        System.out.print("Enter Unit Price: ");
        price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        quantity = sc.nextInt();
    }

    void calculateBill() {
        totalAmount = price * quantity;
    }

    void display() {
        System.out.println("\n--- Product Invoice ---");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Unit Price   : ₹" + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total Amount : ₹" + totalAmount);
    }
}

public class Q03_ProductBilling {
    public static void main(String[] args) {
        Product p = new Product();
        p.read();
        p.calculateBill();
        p.display();
    }
}
