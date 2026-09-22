# Session 13: Java Reflection API & Dynamic Introspection

## 1. What is Java Reflection?
Reflection is an API that allows an executing Java program to examine, inspect, and manipulate its own internal structures (classes, interfaces, constructors, methods, and fields) at runtime without knowing their names at compile time.

Package: `java.lang.reflect`

---

## 2. Why Reflection? (Use Cases)
- **Frameworks & Dependency Injection**: Spring uses reflection to instantiate beans, inject `@Autowired` dependencies, and manage lifecycle.
- **Object-Relational Mapping (ORM)**: Hibernate inspects entities to map Java fields directly to database columns.
- **Testing Tools**: JUnit inspects test classes for `@Test` methods and invokes them dynamically.
- **JSON / XML Serialization**: Jackson and Gson inspect private fields to serialize/deserialize objects without requiring explicit mappings.
- **IDEs**: Code completion and dynamic debugger inspectors.

---

## 3. Core Reflection Classes & Methods

### Obtaining the `Class<?>` Object:
```java
// 1. Via class literal
Class<?> clazz1 = Employee.class;

// 2. Via instance method
Employee emp = new Employee();
Class<?> clazz2 = emp.getClass();

// 3. Via Class.forName (dynamic loading)
Class<?> clazz3 = Class.forName("com.cdac.assignments.employee_lab.Employee");
```

### Inspecting Class Metadata:
```java
System.out.println("Class Name: " + clazz.getName());
System.out.println("Superclass: " + clazz.getSuperclass().getName());

// Interfaces
Class<?>[] interfaces = clazz.getInterfaces();

// Constructors
Constructor<?>[] constructors = clazz.getDeclaredConstructors();

// Fields (including private fields)
Field[] fields = clazz.getDeclaredFields();
for (Field f : fields) {
    System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());
}

// Methods
Method[] methods = clazz.getDeclaredMethods();
for (Method m : methods) {
    System.out.println(m.getName() + " returns " + m.getReturnType().getSimpleName());
}
```

### Accessing Private Members at Runtime:
```java
Field privateField = clazz.getDeclaredField("salary");
privateField.setAccessible(true); // Bypass private access check
privateField.set(empInstance, 95000.0);
```

---

## 4. Considerations & Drawbacks
1. **Performance Overhead**: Dynamic method lookup and parameter boxing are significantly slower than direct byte-code invocation. Modern JIT compilers cannot optimize reflective calls as effectively.
2. **Breaks Encapsulation**: Accessing `private` internals circumvents design contracts and can lead to fragile code.
3. **Security Constraints**: Java Security Manager and modern Java module system (Java 9+ JPMS) restrict reflective access across packages unless explicitly opened with `opens` directives.
4. **Compile-time Type Safety Loss**: Errors surface as runtime `ClassNotFoundException` or `NoSuchMethodException` instead of compile errors.
