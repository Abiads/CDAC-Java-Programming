# Java Notes DAY4 – Classes and Objects in Java


## 1. Object-Oriented Programming (OOP) Overview

Object-Oriented Programming is a paradigm centered around **Classes** (blueprints) and **Objects** (real-world instances that bundle state and behavior).

The Four Pillars of OOP:

- **Encapsulation: **Wrapping data (variables) and code (methods) together.

- **Inheritance: **Mechanism where child classes inherit properties from parent classes.

- **Polymorphism: **Ability to take multiple forms (overloading & overriding).

- **Abstraction: **Hiding implementation details and showing only essentials.

> **In short:** Classes define the structure; objects represent the concrete instances created in memory.


## 2. What is a Class?

A class is a **user-defined data type and blueprint** that defines what attributes and methods objects of its type will have. A class does not occupy memory for its instance fields until an object is instantiated.

```java
class Student {
    // 1. Instance Variables (State)
    int rollNo;
    String name;
    double marks;

    // 2. Methods (Behavior)
    void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
        System.out.println("Marks  : " + marks);
    }
}
```


## 3. What is an Object?

An object is a **real-world entity and instance of a class**. Every object has three primary characteristics:

- **State: **Represented by the values stored in its fields (e.g. rollNo = 101).

- **Behavior: **Represented by methods it can execute (e.g. displayDetails()).

- **Identity: **Unique memory address managed by the JVM.


## 4. Creating and Instantiating Objects

Objects are created using the 'new' keyword:

```java
Student s1 = new Student();

Breakdown:
Student s1    -> Declares a reference variable on the Stack
new           -> Allocates memory on the Heap for the object
Student()     -> Invokes the constructor to initialize state
=             -> Stores reference (Heap address) in s1
```


### Memory Representation

```java
  STACK (References)                  HEAP (Objects)
┌───────────────────┐             ┌─────────────────────────┐
│ s1 [0x1000] ──────┼────────────>│ rollNo: 101             │
│                   │             │ name: "Rahul"           │
│ s2 [0x2000] ──────┼──────────┐  │ marks: 85.0             │
└───────────────────┘          │  └─────────────────────────┘
                               │  ┌─────────────────────────┐
                               └─>│ rollNo: 102             │
                                  │ name: "Pooja"           │
                                  │ marks: 92.5             │
                                  └─────────────────────────┘
```


## 5. Constructors in Java

A constructor is a **special member method** invoked automatically when an object is created to initialize its state.


### Rules for Constructors

- Must have the exact same name as the class.

- Must NOT have any return type, not even void.

- Invoked automatically upon creation via 'new'.

- Cannot be static, final, or abstract.


### Types of Constructors

**1. Default Constructor: **Synthesized by Java compiler if NO constructor is defined in the class.

**2. No-Argument Constructor: **Explicitly defined by programmer without parameters.

**3. Parameterized Constructor: **Accepts parameters to initialize instance fields with custom values.

```java
class Student {
    int rollNo;
    String name;

    // Parameterized Constructor
    Student(int r, String n) {
        rollNo = r;
        name = n;
    }
}
```


## 6. The 'this' Keyword

In Java, **this** is a reference variable that refers to the **current invoking object**.


### Key Usages of 'this':

**1. Resolving Variable Shadowing: **Differentiates instance fields from constructor parameters when names match.

```java
class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;       // this.id refers to instance field
        this.name = name;   // name refers to local parameter
    }
}
```

**2. Constructor Chaining using this(): **Invokes another constructor in the same class. Must be the FIRST statement!

```java
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name) {
        this(id, name, 0.0); // Calls 3-arg constructor
    }

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
```


## 7. Complete Classroom Example

```java
class BankAccount {
    int accountNo;
    String accountHolder;
    double balance;

    BankAccount(int accountNo, String accountHolder, double balance) {
        this.accountNo = accountNo;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs. " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs. " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void displayDetails() {
        System.out.println("Account No : " + accountNo);
        System.out.println("Holder     : " + accountHolder);
        System.out.println("Balance    : Rs. " + balance);
    }
}

public class TestAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1001, "Ramesh", 5000.0);
        acc.displayDetails();
        acc.deposit(2500.0);
        acc.withdraw(1000.0);
        acc.displayDetails();
    }
}
```


## 8. Comparison: Method vs Constructor


| Feature | Constructor | Method |
| --- | --- | --- |
| Purpose | Initializes state of new object | Defines behavior/task of object |
| Name | Must match class name exactly | Can be any valid identifier |
| Return Type | No return type (not even void) | Must declare a return type (or void) |
| Invocation | Called automatically upon 'new' | Called explicitly using '.' operator |
| Inheritance | Not inherited by subclasses | Inherited by subclasses |

