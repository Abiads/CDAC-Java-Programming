# CDAC PGCP-AI: Advanced Java Programming Coursework

Welcome to the **CDAC ACTS Pune - PGCP-AI Advanced Programming for AI (Java Programming)** repository.

This repository is organized according to the official syllabus (`05_Java Programming.pdf`), containing structured notes, assignments, problem banks, and a pre-configured Eclipse IDE Java project.

---

## 📁 Repository Structure

```
├── 05_Java Programming.pdf          # Official CDAC PGCP-AI Java Syllabus
├── Day01/                           # Original Day 1 documents (.docx)
│   ├── Java Assignment 1.docx
│   └── Java Notes DAY1.docx
│
├── Notes/                           # Detailed Session-by-Session Theory Notes
│   ├── 00_Course_Syllabus_Roadmap.md
│   ├── Session_01_02_Java_Basics_ControlFlow.md
│   ├── Session_03_04_OOP_Inheritance_Polymorphism.md
│   ├── Session_05_Exception_Handling.md
│   ├── Session_06_Generics_Collections_Enums.md
│   ├── Session_07_08_Functional_Programming_Lambdas.md
│   ├── Session_09_10_StreamAPI_DateTime.md
│   ├── Session_11_12_Concurrency_Multithreading.md
│   ├── Session_13_Reflection_API.md
│   ├── Session_14_NodeJS_Overview_Comparison.md
│   └── Session_15_Spring_Framework_Overview.md
│
├── Assignments/                     # Assignments & Problem Banks
│   ├── Day01_Basic_Programs/
│   │   └── Assignment_01_Problems.md # 10 Problems (Arithmetic, Interest, Voting, etc.)
│   ├── Day02_Control_Flow/
│   │   └── Assignment_02_Problems.md # 10 Problems (Bills, Grades, Discounts, Tickets, etc.)
│   ├── Day03_Loops_and_Arrays/
│   │   └── Assignment_03_Problems.md # 10 Problems (Primes, Fib, Min/Max, Sort, Matrix)
│   ├── Lab_Employee_Management/
│   │   └── Problem_Statement.md      # Sessions 7 & 8 Official Lab Assignment
│   └── Practice_Bank/
│       └── Syllabus_Practice_Questions.md
│
└── CDAC_Java_Project/               # Pre-Configured Eclipse Java Project
    ├── .project                     # Eclipse project definition
    ├── .classpath                   # Eclipse source & JRE library paths
    ├── .settings/                   # JDT compiler compliance (Java 17+)
    ├── README.md                    # Eclipse import and usage guide
    └── src/
        └── com/cdac/
            ├── assignments/
            │   ├── day01/           # Q01 through Q10 runnable implementations
            │   ├── day02/           # Q01 through Q10 runnable implementations
            │   ├── day03/           # Q01 through Q10 (Loops & Arrays)
            │   └── employee_lab/    # Employee & EmployeeManagementDemo
            ├── practice/            # Syllabus Practice Bank Implementations
            │   ├── module01_oop/    # Bank Account Hierarchy & Palindromes
            │   ├── module02_exceptions/ # Custom Checked/Unchecked Exceptions
            │   ├── module03_collections/ # Generic Pair & Word Frequency Map
            │   ├── module04_streams/    # Student Grade Streams & Fibonacci
            │   ├── module05_concurrency/ # Producer-Consumer & Thread Sync
            │   └── module06_reflection/ # Class Inspector Demo
            ├── session01_basics/    # JVM, Data Types, Control Statements
            ├── session03_oop/       # OOP, Encapsulation, Polymorphism, Strings
            ├── session05_exceptions/ # Custom & built-in exception handling
            └── session06_collections/ # Generics, Enums, Lists, Sets, Maps
```

---

## ⚡ Quick Start with Eclipse IDE

1. Launch **Eclipse IDE**.
2. Go to **File** -> **Import...** -> **General** -> **Existing Projects into Workspace**.
3. Select `CDAC_Java_Project` as the root directory.
4. Click **Finish**.
5. Open any class under `src/` and press `Ctrl + F11` to run.
