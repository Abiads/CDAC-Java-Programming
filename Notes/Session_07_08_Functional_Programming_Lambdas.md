# Sessions 7 & 8: Functional Programming & Lambda Expressions

## 1. Functional Programming Overview
Functional programming treats computation as the evaluation of mathematical functions, avoiding mutable state and side effects.
Java adopted functional paradigms in Java 8 by introducing **Lambda Expressions**, **Functional Interfaces**, and the **Stream API**.

---

## 2. Functional Interfaces & `@FunctionalInterface`
A **Functional Interface** is an interface that contains **exactly one abstract method (SAM)**. It may contain any number of `default` or `static` methods.

```java
@FunctionalInterface
public interface MathOperation {
    int operate(int a, int b);
}
```

---

## 3. Lambda Expressions Syntax
Lambdas provide a concise syntax to implement functional interfaces:
```
(parameters) -> { body }
```

```java
// Traditional Anonymous Inner Class:
MathOperation addOld = new MathOperation() {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
};

// Lambda Expression:
MathOperation add = (a, b) -> a + b;
System.out.println("Sum: " + add.operate(10, 20));
```

### Method References (`::`)
A shorthand notation for calling an existing method directly:
- Static method: `Math::max` (equivalent to `(a, b) -> Math.max(a, b)`)
- Instance method of an object: `System.out::println`
- Constructor reference: `ArrayList::new`

---

## 4. Built-in Functional Interfaces in `java.util.function`

| Interface | Method Signature | Purpose | Example |
| :--- | :--- | :--- | :--- |
| **`Predicate<T>`** | `boolean test(T t)` | Evaluates a boolean condition | `emp -> emp.getSalary() > 50000` |
| **`Function<T, R>`** | `R apply(T t)` | Transforms an input of type `T` into `R` | `emp -> emp.getName()` |
| **`Consumer<T>`** | `void accept(T t)` | Consumes data without returning anything | `emp -> System.out.println(emp)` |
| **`Supplier<T>`** | `T get()` | Generates or supplies a value without input | `() -> new Employee(101, "Alice")` |
| **`BiFunction<T, U, R>`** | `R apply(T t, U u)` | Transforms two inputs into a result | `(a, b) -> a + b` |

---

## 5. Impact of Functional Programming on Collections

1. **`Iterable.forEach(Consumer)`**:
   ```java
   List<String> names = List.of("CDAC", "Pune", "Java");
   names.forEach(System.out::println);
   ```
2. **`Collection.removeIf(Predicate)`**:
   ```java
   List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
   numbers.removeIf(n -> n % 2 == 0); // removes all even numbers
   ```
3. **`List.replaceAll(UnaryOperator)`**:
   ```java
   List<String> cities = new ArrayList<>(List.of("mumbai", "pune", "delhi"));
   cities.replaceAll(String::toUpperCase);
   ```
4. **`Map.forEach(BiConsumer)`**:
   ```java
   map.forEach((k, v) -> System.out.println(k + " = " + v));
   ```
