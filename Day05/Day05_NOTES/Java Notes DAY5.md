# Java Notes DAY5 – Inheritance in Java


## 1. What is Inheritance?

Inheritance is an OOP mechanism where a new class (**Subclass / Child**) derives fields and methods from an existing class (**Superclass / Parent**).

**Keyword: **In Java, inheritance is established using the **extends** keyword.

```java
class SubClass extends SuperClass {
    // Subclass inherits members and adds specialized features
}
```

> **In short:** Inheritance represents the IS-A relationship (e.g. Manager IS-A Employee, Car IS-A Vehicle) and promotes code reusability.


## 2. Types of Inheritance in Java


### A. Single Inheritance (1 Parent -> 1 Child)

```java
    Employee
       ↓
    Manager
```


### B. Multilevel Inheritance (Chain of Classes)

```java
    Vehicle
       ↓
      Car
       ↓
   ElectricCar
```


### C. Hierarchical Inheritance (1 Parent -> Multiple Children)

```java
         BankAccount
         /         \
   Savings       Current
```

**Why Multiple Inheritance is NOT supported with classes: **To prevent the **Diamond Problem** (ambiguity when two parents define the same method). Java solves this via Interfaces.


## 3. The 'super' Keyword

The keyword **super** refers to the immediate parent class. It has three primary uses:

- **super(...) : **Invokes parent class constructor (MUST be the 1st statement in child constructor).

- **super.method() : **Calls overridden parent method from child class.

- **super.field : **Accesses parent field shadowed by child class.


## 4. Constructor Execution Order (Chaining)

**Parent constructors ALWAYS execute BEFORE child constructors**. This ensures parent fields are fully initialized before child initialization begins.

```java
Execution Call Trace:
new Manager()
   ↓ calls
super() -> Employee Constructor
   ↓ calls
super() -> Object Constructor
   ↓ finishes
[1. Object Constructor completes]
   ↓ finishes
[2. Employee Constructor completes]
   ↓ finishes
[3. Manager Constructor completes]
```


## 5. Single Inheritance Example: Employee & Manager

```java
class Employee {
    int employeeId;
    String employeeName;
    double basicSalary;

    Employee(int employeeId, String employeeName, double basicSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Basic Salary  : Rs. " + basicSalary);
    }
}

class Manager extends Employee {
    String department;
    double bonus;

    Manager(int employeeId, String employeeName, double basicSalary, String department, double bonus) {
        super(employeeId, employeeName, basicSalary); // Reuses parent constructor
        this.department = department;
        this.bonus = bonus;
    }

    double calculateTotalSalary() {
        return calculateSalary() + bonus;
    }

    void displayManagerDetails() {
        displayEmployeeDetails(); // Reuses parent display
        System.out.println("Department    : " + department);
        System.out.println("Bonus         : Rs. " + bonus);
        System.out.println("Total Salary  : Rs. " + calculateTotalSalary());
    }
}
```


## 6. Multilevel Inheritance Example: Vehicle Hierarchy

```java
class Vehicle {
    String vehicleNo;
    String brand;
    double price;

    Vehicle(String vehicleNo, String brand, double price) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.price = price;
    }
    double calculateTax() { return price * 0.10; }
}

class Car extends Vehicle {
    String model;
    String fuelType;

    Car(String vehicleNo, String brand, double price, String model, String fuelType) {
        super(vehicleNo, brand, price);
        this.model = model;
        this.fuelType = fuelType;
    }
    double calculateInsurance() { return price * 0.05; }
}

class ElectricCar extends Car {
    double batteryCapacity;
    double chargingTime;

    ElectricCar(String vehicleNo, String brand, double price, String model, String fuelType, double batteryCapacity, double chargingTime) {
        super(vehicleNo, brand, price, model, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }
    double calculateRange() { return batteryCapacity * 5.0; }
}
```


## 7. Member Accessibility in Inheritance


| Modifier | Same Class | Subclass (Same Pkg) | Subclass (Diff Pkg) | World |
| --- | --- | --- | --- | --- |
| private | Yes | No | No | No |
| default | Yes | Yes | No | No |
| protected | Yes | Yes | Yes | No |
| public | Yes | Yes | Yes | Yes |



## 8. Comparison: 'this' vs 'super'


| Feature | this Keyword | super Keyword |
| --- | --- | --- |
| Refers to | Current invoking object instance | Immediate parent class instance |
| Constructor call | this(...) calls current class constructor | super(...) calls parent class constructor |
| Placement | Must be 1st statement in constructor | Must be 1st statement in constructor |
| Member access | this.field accesses current class field | super.field accesses parent class field |

