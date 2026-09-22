# CDAC Java Practice Question Bank

A curated set of practical exercises organized by syllabus modules to prepare for evaluations, lab exams, and interviews.

---

## Module 1: OOP & Inheritance (Sessions 3 & 4)
1. **Bank Account Hierarchy**:
   - Create an abstract class `Account` with fields `accountNumber`, `holderName`, `balance` and abstract methods `deposit(double amt)` and `withdraw(double amt)`.
   - Create concrete subclasses `SavingsAccount` (minimum balance limit) and `CurrentAccount` (overdraft limit).
   - Demonstrate dynamic method dispatch and runtime polymorphism.
2. **String Reversal & Palindrome Checker**:
   - Write a program to test whether a given string is a palindrome using both manual pointer swapping and `StringBuilder.reverse()`.

---

## Module 2: Exception Handling (Session 5)
1. **Custom Banking Exceptions**:
   - Create a `InsufficientBalanceException` (checked) and `InvalidAmountException` (unchecked).
   - In a simulated ATM program, validate user withdrawals and handle these exceptions gracefully with meaningful error messages.
2. **Nested Try-Catch Block Demonstration**:
   - Write a program showing an outer try-catch handling array index errors and an inner try-catch handling numeric parse/division errors.

---

## Module 3: Generics & Collections (Session 6)
1. **Generic Key-Value Pair**:
   - Implement a generic class `Pair<K, V>` with methods `getKey()`, `getValue()`, `setKey()`, and `setValue()`.
2. **Word Frequency Counter**:
   - Read a paragraph of text, sanitize punctuation, and count the occurrences of each unique word using a `Map<String, Integer>` (`HashMap` or `TreeMap`).

---

## Module 4: Streams & Functional Programming (Sessions 7 - 10)
1. **Student Grade Analyzer**:
   - Given a list of students with attributes `id`, `name`, `score`, `gender`:
     - Filter students with score > 75.
     - Find the student with the highest score (`max`).
     - Calculate the average score using `mapToDouble` and `average()`.
     - Group students by gender using `Collectors.groupingBy()`.
2. **Primitive Stream Generation**:
   - Generate the first 50 Fibonacci numbers using `Stream.iterate` and `limit`.

---

## Module 5: Concurrency & Multithreading (Sessions 11 & 12)
1. **Producer-Consumer Problem**:
   - Implement a bounded buffer using `wait()` and `notify()` where a Producer thread produces items and a Consumer thread consumes them safely.
2. **Synchronized Bank Balance Update**:
   - Spawn multiple threads simulating concurrent deposits and withdrawals on the same bank account to demonstrate race condition prevention with `synchronized`.

---

## Module 6: Reflection API (Session 13)
1. **Class Inspector**:
   - Accept a fully-qualified class name from the console (e.g., `java.util.ArrayList`) and print:
     - All implemented interfaces.
     - All public and private fields with their data types.
     - All declared methods with their return types and parameters.
