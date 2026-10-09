# Java Notes DAY6 – Polymorphism in Java


## 1. What is Polymorphism?

Polymorphism originates from Greek: **Poly** (many) + **Morph** (forms). In Java, it is the ability of an entity (method, object) to behave differently based on context.

```java
                 Polymorphism in Java
                          │
            ┌─────────────┴─────────────┐
            │                           │
     Compile-Time                    Runtime
  (Static Polymorphism)       (Dynamic Polymorphism)
            │                           │
   Method Overloading          Method Overriding
```

> **In short:** Same name, different behavior. Overloading resolves at compile time; Overriding resolves at runtime.


## 2. Method Overloading (Compile-Time Polymorphism)

Method Overloading occurs when a class has **multiple methods with the SAME name** but **DIFFERENT parameter lists**.


### Rules for Method Overloading:

- **1. Different Number of Parameters: **add(int a, int b) vs add(int a, int b, int c)

- **2. Different Data Types: **add(int a, int b) vs add(double a, double b)

- **3. Different Sequence of Types: **print(int a, String b) vs print(String a, int b)

**Rule to Remember: **Changing ONLY the return type is NOT valid overloading and causes a compiler error because the compiler cannot determine which method to call.


### Method Overloading Example: Electricity Bill

```java
class ElectricityBill {
    int consumerNo;
    String consumerName;
    int unitsConsumed;

    ElectricityBill(int consumerNo, String consumerName, int unitsConsumed) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.unitsConsumed = unitsConsumed;
    }

    // Overloaded Method 1: Default rate Rs. 8/unit
    double calculateBill() {
        return unitsConsumed * 8.0;
    }

    // Overloaded Method 2: Custom rate with stored units
    double calculateBill(double rate) {
        return unitsConsumed * rate;
    }

    // Overloaded Method 3: Custom rate with custom units
    double calculateBill(double rate, int units) {
        return units * rate;
    }
}
```


## 3. Method Overriding (Runtime Polymorphism)

Method Overriding occurs when a **subclass provides its own specific implementation** of a method that is already declared in its superclass.


### Rules for Method Overriding:

- **Exact same method name and parameter list.**

- **Compatible return type **(same primitive type or covariant class type).

- **Access modifier cannot be more restrictive **(public in parent cannot become default or private in child).

- **Cannot override: **private methods (not visible), static methods (method hiding), and final methods (cannot be modified).

- **@Override annotation: **Instructs compiler to verify valid override, catching typos at compile-time.


## 4. Dynamic Method Dispatch (Runtime Binding)

When an overridden method is called through a superclass reference variable (**Upcasting**), Java determines which version to invoke at **runtime** based on the actual object created in the Heap.

```java
Superclass Ref (Stack)             Actual Object (Heap)
┌─────────────────┐               ┌────────────────────────────────┐
│ BankAccount acc ┼──────────────>│ Actual Type: SavingsAccount    │
└─────────────────┘               ├────────────────────────────────┤
                                  │ Overridden calculateInterest() │ <── Executed!
                                  └────────────────────────────────┘
```


## 5. Hierarchical Method Overriding: Bank Account

```java
class BankAccount {
    int accountNo;
    String accountHolderName;
    double balance;

    BankAccount(int accountNo, String accountHolderName, double balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // General implementation in superclass
    double calculateInterest() {
        return balance * 0.02; // Default 2%
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNo, String accountHolderName, double balance, double interestRate) {
        super(accountNo, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return (balance * interestRate) / 100.0;
    }
}

class CurrentAccount extends BankAccount {
    double interestRate;

    CurrentAccount(int accountNo, String accountHolderName, double balance, double interestRate) {
        super(accountNo, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return (balance * interestRate) / 100.0;
    }
}
```


## 6. Method Overriding: Hospital Treatment Cost

```java
class Patient {
    int patientId;
    String patientName;
    int age;

    Patient(int patientId, String patientName, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
    }

    double calculateTreatmentCost() {
        return 500.0; // Base charge
    }
}

class InPatient extends Patient {
    int numberOfDays;
    double roomCharge;

    InPatient(int patientId, String patientName, int age, int numberOfDays, double roomCharge) {
        super(patientId, patientName, age);
        this.numberOfDays = numberOfDays;
        this.roomCharge = roomCharge;
    }

    @Override
    double calculateTreatmentCost() {
        return numberOfDays * roomCharge;
    }
}

class OutPatient extends Patient {
    double consultationFee;
    double medicineCost;

    OutPatient(int patientId, String patientName, int age, double consultationFee, double medicineCost) {
        super(patientId, patientName, age);
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
    }

    @Override
    double calculateTreatmentCost() {
        return consultationFee + medicineCost;
    }
}
```


## 7. Comprehensive Comparison: Overloading vs Overriding


| Criterion | Method Overloading | Method Overriding |
| --- | --- | --- |
| Concept | Same method name, different parameters | Subclass redefines superclass method |
| Location | Within the SAME class | Between SUPERCLASS and SUBCLASS |
| Parameters | MUST be different | MUST be exactly the same |
| Return Type | Can be different or same | Must be same or covariant subclass type |
| Binding Time | Compile-Time (Early Binding / Static) | Runtime (Late Binding / Dynamic) |
| Inheritance | Not required | Strictly required |
| private / static | Can overload static or private methods | Cannot override static or private methods |
| Performance | Faster (compiler resolves method call) | Slight overhead due to dynamic lookup |

