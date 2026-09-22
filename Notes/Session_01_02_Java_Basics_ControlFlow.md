# Sessions 1 & 2: Java Basics, JVM Architecture & Control Flow

## 1. Introduction to Java & JVM Architecture
Java is an object-oriented, class-based, write-once-run-anywhere (WORA) language.

```
Source Code (.java)  ──>  javac (Compiler)  ──>  Bytecode (.class)  ──>  JVM (Interpreter / JIT)  ──>  Native Machine Code
```

### Components:
- **JDK (Java Development Kit)**: Contains developer tools (`javac`, `jar`, `javadoc`, `jdb`) + JRE.
- **JRE (Java Runtime Environment)**: Contains JVM + Standard class libraries (`rt.jar` / modules).
- **JVM (Java Virtual Machine)**: Responsible for class loading, bytecode verification, execution, and memory management (Garbage Collection).

### JVM Internal Architecture:
1. **ClassLoader Subsystem**:
   - *Loading*: Bootstrap, Extension/Platform, and Application ClassLoaders.
   - *Linking*: Verification (ensures bytecode safety), Preparation (allocates static memory), Resolution (symbolic references to direct references).
   - *Initialization*: Static variables initialized, static blocks executed.
2. **JVM Memory Areas**:
   - **Method Area (Metaspace)**: Class metadata, static variables, bytecode instructions.
   - **Heap Memory**: All created objects and instance variables live here (managed by GC).
   - **JVM Stack**: Stack frames per thread storing local variables, operand stack, and frame data.
   - **PC Registers**: Current instruction address per thread.
   - **Native Method Stack**: For C/C++ native method execution (via JNI).
3. **Execution Engine**:
   - **Interpreter**: Interprets bytecode line-by-line for fast startup.
   - **JIT (Just-In-Time) Compiler**: Compiles frequently executed bytecode ("hot spots") into direct native machine code.
   - **Garbage Collector (GC)**: Reclaims unreferenced heap objects automatically.

---

## 2. Variables, Scopes & Data Types

### Data Types in Java
- **Primitive (8 types)**:
  - Integer numbers: `byte` (8-bit), `short` (16-bit), `int` (32-bit), `long` (64-bit with suffix `L`)
  - Floating point: `float` (32-bit with suffix `f`), `double` (64-bit)
  - Character: `char` (16-bit Unicode)
  - Logical: `boolean` (`true` or `false`)
- **Reference Types**:
  - Classes, Interfaces, Arrays, Enums, Strings.

### Scope of Variables
1. **Local Variables**: Declared inside a method, constructor, or block. Created upon entry and destroyed upon exit. Must be initialized before use.
2. **Instance Variables (Fields)**: Declared inside a class but outside methods. Initialized with default values (`0`, `0.0`, `false`, `null`). Each instance has its own copy.
3. **Static (Class) Variables**: Declared with the `static` keyword. Only one copy exists per class shared across all instances.

---

## 3. Wrapper Classes & Autoboxing
Wrapper classes convert primitives into objects:
- `int` -> `java.lang.Integer`
- `double` -> `java.lang.Double`
- `boolean` -> `java.lang.Boolean`
- `char` -> `java.lang.Character`

```java
// Autoboxing (primitive to wrapper object)
Integer obj = 50; 

// Unboxing (wrapper object to primitive)
int val = obj;
```
Useful utility methods:
- `Integer.parseInt("123")`
- `Double.parseDouble("45.67")`
- `Integer.toBinaryString(10)`

---

## 4. Operators & Control Flow Statements

### Operators
- **Arithmetic**: `+`, `-`, `*`, `/`, `%`
- **Unary**: `++`, `--`, `+`, `-`, `!`
- **Relational**: `==`, `!=`, `>`, `<`, `>=`, `<=`
- **Logical**: `&&` (short-circuit AND), `||` (short-circuit OR), `!`
- **Bitwise**: `&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`
- **Assignment**: `=`, `+=`, `-=`, `*=`, `/=`, `%=`
- **Ternary**: `condition ? expr1 : expr2`

### Decision Making
- `if`, `if-else`, nested `if`, `else-if` ladder.
- `switch` statement (supports `int`, `char`, `String`, `enum`). In modern Java (17+), switch expressions yield values directly:
  ```java
  String dayType = switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
      case SATURDAY, SUNDAY -> "Weekend";
      default -> "Invalid";
  };
  ```

### Looping Constructs
- `for` loop (standard counter-controlled)
- Enhanced `for-each` loop (iterating through arrays / collections)
- `while` loop (entry-controlled loop)
- `do-while` loop (exit-controlled loop; executes at least once)
- `break` (exit loop or switch) and `continue` (skip to next iteration)
