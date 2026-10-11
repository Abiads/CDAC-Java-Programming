# Java Notes DAY7 – Abstraction, Interfaces, Exception Handling & Collections


## 1. What is Abstraction?

Abstraction is the OOP principle of **hiding implementation details and showing only the essential functionality** to the user. It focuses on what an object does rather than how it does it.

Java achieves abstraction using two mechanisms:

- **Abstract Classes: **Partial abstraction (0% to 100%)

- **Interfaces: **Complete abstraction (100%)

> **In short:** Abstraction shields users from internal complexity and enforces consistent design contracts across subclasses.


## 2. Abstract Classes and Methods

An **abstract class** is declared with the keyword 'abstract'. Key characteristics:

- Cannot be instantiated directly (cannot create objects using 'new AbstractClass()').

- Can have both abstract methods (without body) and non-abstract concrete methods (with body).

- Can have constructors, fields, and static methods.

- Any subclass MUST implement all abstract methods unless the subclass is also abstract.

```java
abstract class Vehicle {
    String vehicleNo;
    double rentalRate;

    Vehicle(String vehicleNo, double rentalRate) {
        this.vehicleNo = vehicleNo;
        this.rentalRate = rentalRate;
    }

    // Concrete method with body
    void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNo);
    }

    // Abstract method without body (Must be implemented by subclasses)
    abstract double calculateRental(int days);
}

class Car extends Vehicle {
    double insurance;

    Car(String vehicleNo, double rentalRate, double insurance) {
        super(vehicleNo, rentalRate);
        this.insurance = insurance;
    }

    @Override
    double calculateRental(int days) {
        return (rentalRate * days) + insurance;
    }
}
```


## 3. Interfaces in Java

An **interface** is a completely abstract blueprint containing method signatures and constants. Classes implement interfaces using the **implements** keyword.


### Why use Interfaces?

- Enforces a standard contract that multiple unrelated classes can implement.

- Achieves multiple inheritance in Java (a class can implement multiple interfaces: implements A, B).

- Supports loose coupling in application architecture.

```java
interface Payment {
    void processPayment(double amount);
    void displayPaymentDetails();
}

class UPIPayment implements Payment {
    String upiId;

    UPIPayment(String upiId) { this.upiId = upiId; }

    public void processPayment(double amount) {
        System.out.println("Paid Rs. " + amount + " via UPI: " + upiId);
    }

    public void displayPaymentDetails() {
        System.out.println("UPI Mode: " + upiId);
    }
}
```


## 4. Comparison: Abstract Class vs Interface


| Feature | Abstract Class | Interface |
| --- | --- | --- |
| Keyword | abstract class | interface / implements |
| Methods | Both abstract and concrete methods | Abstract methods (default/static in Java 8+) |
| Multiple Inheritance | Not supported (extends one class) | Supported (implements multiple) |
| Variables | Can have instance and static fields | Fields are public static final by default |
| Constructor | Can have constructors | Cannot have constructors |
| Speed | Slightly faster | Slightly slower due to search in indirection |



## 5. Exception Handling in Java

An **exception** is an unexpected event that disrupts the normal execution flow of a program. Java provides a structured mechanism to handle runtime errors gracefully.


### The 5 Exception Handling Keywords:

- **try : **Encloses the code that might throw an exception.

- **catch : **Handles the specific exception thrown in the try block.

- **finally : **Block that ALWAYS executes, regardless of whether an exception occurred (used for cleanup).

- **throw : **Explicitly throws an exception instance.

- **throws : **Declares that a method may throw exceptions to its caller.

```java
try {
    int units = sc.nextInt();
    if (units < 0) {
        throw new IllegalArgumentException("Units cannot be negative!");
    }
    double bill = calculate(units);
    System.out.println("Bill: Rs. " + bill);
} catch (InputMismatchException e) {
    System.out.println("Invalid input: Please enter numeric integers.");
} catch (IllegalArgumentException e) {
    System.out.println("Validation error: " + e.getMessage());
} finally {
    System.out.println("Electricity bill processing completed.");
    sc.close();
}
```


## 6. Collections Framework – ArrayList

The Java Collections Framework provides built-in data structures. The **ArrayList<T>** is a dynamically resizable array that grows and shrinks automatically as elements are added or removed.


### Standard Array vs ArrayList


| Feature | Standard Array (int[]) | ArrayList<T> |
| --- | --- | --- |
| Size | Fixed after creation | Dynamic (grows automatically) |
| Types | Primitive and Objects | Objects only (uses Wrapper classes) |
| Methods | Only .length property | add(), get(), remove(), size(), clear() |
| Memory | Contiguous primitive/reference block | Continuous array with internal resizing overhead |



### ArrayList of Custom Objects Example

```java
import java.util.ArrayList;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Demo {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(101, "Laptop", 55000));
        list.add(new Product(102, "Mouse", 500));

        double total = 0;
        for (Product p : list) {
            total += p.price;
        }
        System.out.println("Total Value: Rs. " + total);
    }
}
```


## 7. Quick Summary of Day 7

- **Abstract Class: **Provides partial implementation and common base state.

- **Interface: **Defines pure capability contracts and achieves multiple inheritance.

- **try-catch-finally: **Robust error prevention with guaranteed cleanup in finally.

- **ArrayList: **Dynamic, type-safe list storing collections of custom objects.
