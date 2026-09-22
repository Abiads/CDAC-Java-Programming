# Session 15: Introduction to Spring Framework & Architecture

## 1. What is the Spring Framework?
The **Spring Framework** is an enterprise Java framework that provides comprehensive infrastructure support for developing Java applications.
Core tenets of Spring:
- **Loose Coupling**: Achieved via **Dependency Injection (DI)** and **Inversion of Control (IoC)**.
- **Declarative Programming**: Using annotations like `@Component`, `@Service`, `@Repository`, `@Transactional`.
- **Boilerplate Reduction**: Provides templates (`JdbcTemplate`, `RestTemplate`) that automate tedious plumbing code.

---

## 2. Inversion of Control (IoC) & Dependency Injection (DI)

### Traditional Approach (Tight Coupling):
```java
public class EmployeeService {
    private EmployeeRepository repo = new EmployeeRepository(); // Hardcoded dependency
}
```

### Spring IoC Approach (Loose Coupling):
The Spring IoC Container manages object creation, configuration, and lifecycle. Dependencies are injected at runtime via Reflection.
```java
@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) { // Injected by Spring Container
        this.repo = repo;
    }
}
```

---

## 3. Spring Framework Architecture

```
┌────────────────────────────────────────────────────────────────────────┐
│                          Spring Architecture                           │
├────────────────────────────────────────────────────────────────────────┤
│  Web (MVC / REST / WebFlux / WebSocket)                                │
├────────────────────────────────────────────────────────────────────────┤
│  Data Access / Integration (JDBC / ORM / Transactions / JMS / OXM)     │
├────────────────────────────────────────────────────────────────────────┤
│  AOP (Aspect Oriented Programming) & Instrumentation                   │
├────────────────────────────────────────────────────────────────────────┤
│  Core Container (Beans, Core, Context, SpEL - Expression Language)     │
├────────────────────────────────────────────────────────────────────────┤
│  Test Framework (JUnit / Mockito integration)                          │
└────────────────────────────────────────────────────────────────────────┘
```

- **Core Container**:
  - `Beans` & `Core`: Fundamental IoC container (`BeanFactory`).
  - `Context`: Extends BeanFactory (`ApplicationContext`) adding i18n, events, resource loading.
  - `SpEL`: Powerful expression language for querying and manipulating object graphs.
- **Data Access / Integration**: Transaction management and ORM support (Hibernate / JPA).
- **AOP**: Allows separating cross-cutting concerns (logging, security, transaction demarcation) from business logic.

---

## 4. Spring MVC Architecture
Spring MVC is a Model-View-Controller architecture designed around a central servlet: the **`DispatcherServlet`**.

```
Client Browser / REST API
         │ HTTP Request
         ▼
 ┌──────────────────────┐
 │  DispatcherServlet   │ (Front Controller)
 └──────────┬───────────┘
            │ 1. Consults
            ▼
 ┌──────────────────────┐
 │   HandlerMapping     │ (Finds controller matching URL)
 └──────────┬───────────┘
            │ 2. Invokes
            ▼
 ┌──────────────────────┐
 │     Controller       │ (Processes request & interacts with Services/DB)
 └──────────┬───────────┘
            │ 3. Returns Model & View Name / JSON Response Body
            ▼
 ┌──────────────────────┐
 │     ViewResolver     │ (Resolves template, e.g., Thymeleaf / JSP)
 └──────────┬───────────┘
            │ 4. Renders
            ▼
     HTTP Response (HTML / JSON) back to Client
```

Modern Spring Boot applications typically build RESTful APIs where controllers are annotated with `@RestController`, returning JSON serialized by Jackson directly in the response body.
