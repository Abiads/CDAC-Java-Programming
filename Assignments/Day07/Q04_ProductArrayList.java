import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    void display() {
        System.out.printf("ID: %-5d | Name: %-15s | Price: Rs. %.2f\n", productId, productName, price);
    }
}

public class Q04_ProductArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();

        System.out.println("--- Enter Details for 5 Products ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nProduct " + i + ":");
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Product Name: ");
            String name = sc.next();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            productList.add(new Product(id, name, price));
        }

        System.out.println("\n================ All Products ================");
        double totalPrice = 0.0;
        Product highestPriceProduct = productList.get(0);

        for (Product p : productList) {
            p.display();
            totalPrice += p.price;
            if (p.price > highestPriceProduct.price) {
                highestPriceProduct = p;
            }
        }

        System.out.println("==============================================");
        System.out.printf("Total Price of All Products : Rs. %.2f\n", totalPrice);

        System.out.println("\n--- Product with Highest Price ---");
        highestPriceProduct.display();

        sc.close();
    }
}
