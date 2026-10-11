import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: ArrayList Real-World Inventory Problem (10 Marks Target)
 * Problem 3: Product Inventory Management
 * 
 * Based on Day 07 Assignment Question 4:
 * 1. Store Product objects: productId, productName, price, quantity
 * 2. Display complete inventory with subtotal per product (price * quantity)
 * 3. Calculate total inventory valuation
 * 4. Find the most expensive product
 * 5. Search product by Name (case-insensitive)
 * ============================================================================
 */

class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate inventory value for this item
    public double getTotalValue() {
        return price * quantity;
    }

    public void displayProduct() {
        System.out.printf("ID: %-4d | Name: %-15s | Price: Rs.%-8.2f | Qty: %-4d | Value: Rs.%.2f\n",
                id, name, price, quantity, getTotalValue());
    }
}

public class Prob03_ProductInventory_ArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();

        // Add 5 sample products
        inventory.add(new Product(201, "Laptop", 65000.0, 5));
        inventory.add(new Product(202, "Wireless Mouse", 1200.0, 25));
        inventory.add(new Product(203, "Mechanical Keyboard", 3500.0, 10));
        inventory.add(new Product(204, "4K Monitor", 28000.0, 4));
        inventory.add(new Product(205, "USB-C Hub", 1800.0, 15));

        System.out.println("======================================================================");
        System.out.println("                PRODUCT INVENTORY MANAGEMENT SYSTEM                  ");
        System.out.println("======================================================================");

        // 1. Display all products
        System.out.println("\n--- Current Inventory Status ---");
        for (Product p : inventory) {
            p.displayProduct();
        }

        // 2. Calculate Total Valuation & Most Expensive Product
        double totalInventoryValue = 0.0;
        Product mostExpensive = inventory.get(0);

        for (Product p : inventory) {
            totalInventoryValue += p.getTotalValue();
            if (p.price > mostExpensive.price) {
                mostExpensive = p;
            }
        }

        System.out.println("\n--- Inventory Summary ---");
        System.out.printf("Total Inventory Value : Rs. %.2f\n", totalInventoryValue);
        System.out.printf("Highest Priced Item   : %s at Rs. %.2f per unit\n", mostExpensive.name, mostExpensive.price);

        // 3. Search product by Name
        System.out.print("\nEnter Product Name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;
        for (Product p : inventory) {
            if (p.name.equalsIgnoreCase(searchName)) {
                System.out.println("\nProduct Found:");
                p.displayProduct();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No product found with name \"" + searchName + "\".");
        }

        // 4. Update Stock Quantity
        System.out.print("\nEnter Product ID to update stock quantity: ");
        if (sc.hasNextInt()) {
            int targetId = sc.nextInt();
            System.out.print("Enter added quantity: ");
            int addQty = sc.nextInt();

            boolean updated = false;
            for (Product p : inventory) {
                if (p.id == targetId) {
                    p.quantity += addQty;
                    System.out.println("Stock updated! New quantity for " + p.name + " is " + p.quantity);
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                System.out.println("Product ID " + targetId + " not found.");
            }
        }

        sc.close();
    }
}
