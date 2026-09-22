# Session 5: Exception Handling & Robust Architecture

## 1. Exception Hierarchy in Java
An Exception is an abnormal condition that arises during program execution, interrupting normal flow.

```
                    java.lang.Throwable
                       ├── java.lang.Error (Unrecoverable system issues: OutOfMemoryError, StackOverflowError)
                       └── java.lang.Exception
                             ├── Checked Exceptions (IOException, SQLException, ClassNotFoundException)
                             └── java.lang.RuntimeException (Unchecked Exceptions)
                                   ├── NullPointerException
                                   ├── ArithmeticException
                                   ├── ArrayIndexOutOfBoundsException
                                   └── IllegalArgumentException
```

---

## 2. Checked vs. Unchecked Exceptions
| Feature | Checked Exceptions | Unchecked Exceptions (Runtime) |
| :--- | :--- | :--- |
| **Superclass** | Direct subclasses of `Exception` | Subclasses of `RuntimeException` |
| **Check Time** | Checked at **compile-time** | Detected at **runtime** |
| **Handling Rule**| Must be either caught (`try-catch`) or declared (`throws`) | Handling is optional, but recommended for robustness |
| **Common Examples** | `IOException`, `FileNotFoundException`, `ClassNotFoundException` | `ArithmeticException`, `NullPointerException`, `NumberFormatException` |

---

## 3. Exception Handling Keywords

1. **`try`**: Encloses code that may throw an exception.
2. **`catch`**: Handles specific exception types.
   ```java
   try {
       int result = 10 / 0;
   } catch (ArithmeticException ex) {
       System.err.println("Cannot divide by zero: " + ex.getMessage());
   }
   ```
3. **Multi-Catch (Java 7+)**: Grouping unrelated exceptions together.
   ```java
   try {
       // Code
   } catch (IOException | SQLException ex) {
       ex.printStackTrace();
   }
   ```
4. **`finally`**: Block of code that **always executes**, regardless of whether an exception occurred or was handled (useful for resource cleanup).
5. **Try-with-Resources (Java 7+)**: Automatically closes resources implementing `AutoCloseable`.
   ```java
   try (Scanner sc = new Scanner(System.in)) {
       // sc will be automatically closed
   }
   ```
6. **`throw`**: Explicitly throws an exception object:
   ```java
   if (age < 18) {
       throw new IllegalArgumentException("Age must be >= 18");
   }
   ```
7. **`throws`**: Declares in the method signature that the method may pass checked exceptions to the caller.
   ```java
   public void readFile(String path) throws IOException { ... }
   ```

---

## 4. Creating Custom Exceptions
When domain-specific business rules fail, define custom exception classes:

```java
// Custom Checked Exception
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception
public class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
```
