# Sessions 9 & 10: Stream API & Modern Date-Time API

## 1. Introduction to Streams
A **Stream** is a sequence of elements supporting sequential and parallel aggregate operations. Streams do **not** store data; they convey elements from a source (collection, array, I/O channel) through a computational pipeline.

### Streams vs. Collections
| Feature | Collection | Stream |
| :--- | :--- | :--- |
| **Data Storage** | Stores elements in memory | Does not store elements (computes on demand) |
| **Modification** | Can add/remove elements | Does not modify the underlying source |
| **Iteration** | External iteration (`for`, `iterator`) | Internal iteration (`forEach`, `filter`, etc.) |
| **Evaluation** | Eager evaluation | Lazy evaluation (executes only on terminal op) |
| **Reusability** | Traversed multiple times | Consumed once (cannot be reused) |

---

## 2. Stream Pipeline Architecture
A stream pipeline consists of:
1. **Source**: e.g., `list.stream()`
2. **Intermediate Operations (Lazy, returns Stream)**:
   - `filter(Predicate)`: Retains matching elements.
   - `map(Function)`: Transforms each element into another type/value.
   - `sorted(Comparator)`: Orders elements.
   - `flatMap(Function)`: Flattens nested streams/collections into a single stream.
   - `distinct()`: Removes duplicate elements.
   - `limit(n)` and `skip(n)`: Truncates or skips elements.
3. **Terminal Operations (Eager, triggers execution & closes stream)**:
   - `collect(Collectors.toList())`: Gathers elements into a Collection or Map.
   - `forEach(Consumer)`: Performs action for each element.
   - `reduce(BinaryOperator)`: Combines elements into a single aggregate result.
   - `count()`: Total elements.
   - `anyMatch(Predicate)`, `allMatch(Predicate)`, `noneMatch(Predicate)`: Boolean checks.
   - `findFirst()`, `findAny()`: Returns `Optional<T>`.

```java
List<String> result = employees.stream()
    .filter(e -> e.getSalary() > 60000)
    .map(Employee::getName)
    .sorted()
    .collect(Collectors.toList());
```

---

## 3. Primitive Streams (`IntStream`, `LongStream`, `DoubleStream`)
To avoid autoboxing overhead when dealing with primitive numbers:
```java
IntStream.rangeClosed(1, 100) // numbers 1 to 100
    .filter(n -> n % 2 == 0)
    .sum();

// Converting primitive stream to object stream (Boxing)
Stream<Integer> boxedStream = IntStream.of(1, 2, 3).boxed();
```
Key primitive methods: `sum()`, `average()`, `min()`, `max()`, `summaryStatistics()`.

---

## 4. Modern Java Date-Time API (`java.time`)
Introduced in Java 8 (JSR-310) to replace legacy, mutable, non-thread-safe `java.util.Date` and `Calendar`.

- **Core Classes**:
  - `LocalDate`: Date without time (`2026-09-22`).
  - `LocalTime`: Time without date (`10:30:00`).
  - `LocalDateTime`: Combined date and time without timezone (`2026-09-22T10:30:00`).
  - `ZonedDateTime`: Date-time with timezone (`Asia/Kolkata`).
  - `Instant`: Machine timestamp (epoch seconds).
  - `Period`: Date-based amount of time (years, months, days).
  - `Duration`: Time-based amount of time (seconds, nanoseconds).
  - `DateTimeFormatter`: Formatting and parsing thread-safe patterns.

```java
LocalDate today = LocalDate.now();
LocalDate joining = LocalDate.of(2024, Month.JANUARY, 15);
Period tenure = Period.between(joining, today);
System.out.println("Experience: " + tenure.getYears() + " years, " + tenure.getMonths() + " months");
```
