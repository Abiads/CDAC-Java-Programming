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
├── com.cdac.assignments.day01       # 10 runnable programs from Assignment 1
├── com.cdac.assignments.employee_lab # Official Sessions 7 & 8 Employee Lab assignment
├── com.cdac.session01_basics        # JVM, Data Types, Control Statements
├── com.cdac.session03_oop           # Encapsulation, Polymorphism, Strings
├── com.cdac.session05_exceptions    # Exception handling & Custom Exceptions
├── com.cdac.session06_collections   # Collections, Generics, Enums
├── com.cdac.session07_lambdas       # Functional Interfaces & Lambdas
├── com.cdac.session09_streams       # Stream API & java.time Date-Time API
├── com.cdac.session11_concurrency   # Threads, Synchronization & Locks
└── com.cdac.session13_reflection    # Reflection API runtime inspection
```
