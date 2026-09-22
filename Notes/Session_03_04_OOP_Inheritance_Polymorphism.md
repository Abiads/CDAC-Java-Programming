# Sessions 3 & 4: OOP, Inheritance, Polymorphism & String Handling

## 1. Packages & Arrays
- **Packages**: Namespaces that prevent naming conflicts, organize related classes, and provide access protection.
  ```java
  package com.cdac.session03;
  import java.util.ArrayList;
  import static java.lang.Math.*;
  ```
- **Arrays**: Fixed-length homogeneous data structures.
  ```java
  int[] numbers = new int[5];
  int[] primes = {2, 3, 5, 7, 11};
  // 2D Array
  int[][] matrix = {{1, 2}, {3, 4}};
  ```

---

## 2. String vs. StringBuilder vs. StringBuffer
- **`String`**: Immutable sequence of characters stored in the String Constant Pool (Heap). Every modification creates a new object.
  ```java
  String s = "Hello";
  s.concat(" World"); // s is unchanged unless reassigned
  ```
- **`StringBuilder`**: Mutable sequence of characters. Not thread-safe, but significantly faster for string concatenation loops.
  ```java
  StringBuilder sb = new StringBuilder();
  sb.append("CDAC").append(" Pune");
  ```
- **`StringBuffer`**: Mutable and thread-safe (synchronized methods), slightly slower than `StringBuilder`.

---

## 3. Encapsulation, Methods & Constructors
- **Encapsulation**: Binding data and methods together while hiding internal state using `private` fields and exposing `public` getters/setters.
- **Access Modifiers**:
  | Modifier | Same Class | Same Package | Subclass (outside pkg) | World |
  | :--- | :---: | :---: | :---: | :---: |
  | `private` | Yes | No | No | No |
  | Default (no modifier) | Yes | Yes | No | No |
  | `protected` | Yes | Yes | Yes | No |
  | `public` | Yes | Yes | Yes | Yes |
- **Method Overloading**: Same method name with different parameter signatures (compile-time polymorphism).
- **Constructors**: Special initialization blocks named identically to the class with no return type. Can be overloaded. Use `this(...)` to chain constructors.
- **Immutable Classes**: Classes whose state cannot be changed once constructed (e.g., `String`, modern `record` in Java 17). Requirements:
  1. Declare class as `final`.
  2. Declare all fields `private final`.
  3. No setter methods.
  4. Perform deep copies for mutable fields.

---

## 4. Inheritance & Polymorphism
- **Inheritance (`extends`)**: Allows a child class to inherit state and behaviors from a parent class. Supports single inheritance (classes) and multi-level inheritance.
- **Method Overriding**: Redefining a parent class method in a child class with the exact same signature (runtime polymorphism). Annotated with `@Override`.
- **Abstract Classes vs. Interfaces**:
  - **Abstract Class (`abstract class`)**: Can have both abstract methods and concrete methods with state/instance variables. Represents an "is-a" relationship.
  - **Interface (`interface`)**: Defines a contract. All fields are `public static final`. Methods are `public abstract` by default, but can have `default` and `static` methods (Java 8+) and `private` methods (Java 9+). A class can implement multiple interfaces.
- **Polymorphism Concepts**:
  - **Object vs Reference**: `Parent ref = new Child();` The reference type determines which methods are accessible at compile time; the runtime object determines which overridden method executes (Dynamic Method Dispatch / Virtual Methods).
  - **Object Casting**:
    - *Upcasting*: `Parent p = new Child();` (Automatic, safe)
    - *Downcasting*: `Child c = (Child) p;` (Requires explicit cast; check with `instanceof` or pattern matching in Java 17: `if (p instanceof Child c)`).
