# CDAC Java Project - Eclipse IDE Integration Guide

This directory is a ready-to-use, pre-configured Eclipse Java Project. It contains all metadata files (`.project`, `.classpath`, and `.settings`) required by Eclipse to immediately recognize, build, and execute the Java codebase without any manual configuration.

---

## 🚀 How to Import into Eclipse IDE (3 Simple Steps)

### Method 1: Existing Projects into Workspace (Recommended)
1. Open Eclipse IDE.
2. Go to **File** > **Import...**
3. Expand the **General** folder and select **Existing Projects into Workspace**, then click **Next >**.
4. In **Select root directory**, click **Browse...** and select this directory:
   `c:\Users\conne\Downloads\JAVACDAC\CDAC_Java_Project`
5. Ensure `CDAC_Java_Project` is checked in the Projects list.
6. Click **Finish**.

### Method 2: Open Projects from File System
1. In Eclipse, go to **File** > **Open Projects from File System...**
2. Click **Directory...** and select `c:\Users\conne\Downloads\JAVACDAC\CDAC_Java_Project`.
3. Click **Finish**.

---

## 🏃 How to Run Programs in Eclipse

1. In the **Package Explorer** pane on the left, expand:
   `CDAC_Java_Project` > `src` > `com.cdac...`
2. Open any Java file (for example, `com.cdac.assignments.day01.Q01_ArithmeticOperations.java`).
3. Either:
   - Press `Ctrl + F11` (or `Shift + Alt + X`, then `J`), OR
   - Right-click inside the editor -> **Run As** -> **Java Application**, OR
   - Click the green **Run** button on the top toolbar.
4. The output will immediately appear in Eclipse's built-in **Console** tab at the bottom.

---

## 📂 Project Package Structure

```
src/
├── com.cdac.assignments.day01       # 10 runnable programs from Assignment 1 (Basics & Operators)
├── com.cdac.assignments.day02       # 10 runnable programs from Assignment 2 (Control Flow & Slabs)
├── com.cdac.assignments.day03       # 10 runnable programs from Assignment 3 (Loops, Sorting & Matrices)
├── com.cdac.assignments.day04       # 5 solved assignments from Assignment 4 (Classes & Objects)
├── com.cdac.assignments.employee_lab # Official Sessions 7 & 8 Employee Lab assignment
├── com.cdac.practice.module01_oop    # Bank Account Hierarchy & String Palindrome
├── com.cdac.practice.module02_exceptions # Custom Banking Checked/Unchecked Exceptions
├── com.cdac.practice.module03_collections # Generic Pair & Word Frequency Map
├── com.cdac.practice.module04_streams # Student Grade Analyzer & Fibonacci Streams
├── com.cdac.practice.module05_concurrency # Producer-Consumer & Thread Synchronization
├── com.cdac.practice.module06_reflection # Runtime Class Inspector & Introspection
├── com.cdac.session01_basics        # JVM, Data Types, Control Statements
├── com.cdac.session03_oop           # Encapsulation, Polymorphism, Strings
├── com.cdac.session05_exceptions    # Exception handling & Custom Exceptions
└── com.cdac.session06_collections   # Collections, Generics, Enums
```

---

## 📋 Assignments Overview

| Assignment Module | Package | Problems & Description |
| :--- | :--- | :--- |
| **Day 01: Basics & Operators** | `com.cdac.assignments.day01` | Arithmetic, Circle Area, Simple Interest, Fahrenheit, Total/Avg, Even/Odd, Sign Check, Max of 2, Voting, Student Result |
| **Day 02: Control Flow** | `com.cdac.assignments.day02` | Electricity Bill, Student Grade, Product Discount, Largest of 2, Voting Eligibility, Salary Calculation, Temp Check, Calculator, Bus Fare, Mobile Data |
| **Day 03: Loops & Arrays** | `com.cdac.assignments.day03` | Sum of Natural Numbers, Factorial, Prime Check, Fibonacci, Reverse/Palindrome, Array Sum/Avg, Min/Max, Linear Search, Bubble Sort, Matrix Addition |
| **Day 04: Classes & Objects** | `com.cdac.assignments.day04` | Employee Salary (`Employee`), Bank Account (`BankAccount`), Product Invoice (`Product`), Electricity Bill (`ElectricityBill`), Movie Ticket (`MovieTicket`) |
| **Employee Lab** | `com.cdac.assignments.employee_lab` | Sessions 7 & 8 Employee management lab using Java Collections |

