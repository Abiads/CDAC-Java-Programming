# Session 6: Enumerations, Java APIs, Generics & Collections Overview

## 1. Enumerations (`enum`)
An `enum` is a special Java type representing a fixed set of constants.
```java
public enum Day {
    MONDAY("Start of work"),
    FRIDAY("Almost weekend"),
    SUNDAY("Rest day");

    private final String comment;

    Day(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
```
Enums are type-safe, can have fields, constructors, methods, and implement interfaces.

---

## 2. Standard Java APIs
- **`java.lang`** (Imported automatically):
  - `Object`: The root of the class hierarchy (`equals`, `hashCode`, `toString`, `clone`).
  - `Math`: Mathematical functions (`Math.sqrt`, `Math.pow`, `Math.max`, `Math.random`).
  - `System`: Standard I/O, currentTimeMillis, garbage collection trigger.
- **`java.math`**:
  - `BigDecimal` and `BigInteger`: For arbitrary-precision calculations (essential for financial / AI applications to prevent floating-point rounding errors).
- **`java.util`**:
  - Collections, `Scanner`, `Random`, `Objects`, `UUID`, legacy date utilities.

---

## 3. Generics (`<T>`)
Generics enforce compile-time type safety and eliminate the need for manual type casting.

```java
// Generic Class
public class Box<T> {
    private T item;
    public void set(T item) { this.item = item; }
    public T get() { return item; }
}

// Generic Method
public static <E> void printArray(E[] elements) {
    for (E element : elements) {
        System.out.println(element);
    }
}
```
- **Bounded Type Parameters**: `<T extends Number>` restricts `T` to subclasses of `Number`.
- **Wildcards**:
  - Unbounded: `<?>`
  - Upper bounded: `<? extends Number>` (read-only / covariant)
  - Lower bounded: `<? super Integer>` (writeable / contravariant)

---

## 4. Java Collections Framework (JCF) Overview

```
                      Collection<E>
             ┌──────────────┼──────────────┐
          List<E>        Set<E>         Queue<E>
          ├── ArrayList  ├── HashSet    ├── PriorityQueue
          ├── LinkedList ├── TreeSet    └── ArrayDeque
          └── Vector     └── LinkedHashSet
          
                         Map<K, V> (Independent Hierarchy)
                         ├── HashMap
                         ├── TreeMap
                         └── LinkedHashMap
```

### Key Interfaces & Implementations:
1. **`List<E>`**: Ordered, indexed collection allowing duplicate elements.
   - `ArrayList`: Dynamic array; fast random access $O(1)$, slow insertions/deletions $O(n)$.
   - `LinkedList`: Doubly linked list; fast insertions/deletions at ends $O(1)$, slower random access.
2. **`Set<E>`**: Collection that contains no duplicate elements.
   - `HashSet`: Backed by hash table; fast lookup $O(1)$; unordered.
   - `TreeSet`: Sorted set backed by Red-Black tree; elements ordered naturally or via `Comparator` $O(\log n)$.
3. **`Map<K, V>`**: Key-value pairs with unique keys.
   - `HashMap`: Fast hash table implementation; null keys permitted.
   - `TreeMap`: Red-Black tree implementation sorted by keys.
4. **`Iterator<E>`**: Traversal interface supporting `hasNext()`, `next()`, and safe `remove()`.
