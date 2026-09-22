# Session 14: Introduction to Node.js & Runtime Architecture Comparison

## 1. What is Node.js?
Node.js is an open-source, cross-platform, asynchronous event-driven JavaScript runtime environment built on Google Chrome's V8 JavaScript Engine. It executes JavaScript outside the web browser on the server side.

---

## 2. Browser JavaScript vs. Node.js

| Feature | Browser JavaScript | Node.js |
| :--- | :--- | :--- |
| **Execution Environment** | Inside Web Browsers (Chrome, Firefox, Safari) | Server-side / Terminal via Google V8 engine |
| **Global Object** | `window` / `document` | `global` / `process` |
| **File System Access** | Restricted / No direct disk access (Security Sandbox) | Full OS disk and I/O access via `fs` module |
| **Hardware / OS Access** | No direct access | Full access (network sockets, OS metrics, CPU) |
| **Module Systems** | ES Modules (`import/export`) | CommonJS (`require`) & ES Modules (`import`) |
| **Typical Role** | DOM manipulation, Client-side UI logic | Backend REST APIs, microservices, tooling |

---

## 3. Node.js REPL & Commands
- **REPL (Read-Eval-Print-Loop)**: Interactive shell for quick prototyping and running JavaScript snippets directly in the terminal:
  ```bash
  node
  > const arr = [10, 20, 30];
  > arr.map(x => x * 2);
  [ 20, 40, 60 ]
  ```
- **Running a Script**:
  ```bash
  node app.js
  ```

---

## 4. Architecture Comparison: Java (JVM) vs. Node.js (V8)

```
        Java (Multithreaded Model)                    Node.js (Event-Driven Model)
     ┌────────────────────────────────┐            ┌────────────────────────────────┐
     │  Thread Pool (1 per Request)   │            │  Single-Threaded Event Loop    │
     │  Request 1 ──> Thread 1        │            │  Request 1 ──┐                 │
     │  Request 2 ──> Thread 2        │            │  Request 2 ──┼──> Event Loop   │
     │  Request 3 ──> Thread 3        │            │  Request 3 ──┘   (libuv pool)  │
     │  Heavy CPU / Computation       │            │  High I/O Non-Blocking Apps    │
     └────────────────────────────────┘            └────────────────────────────────┘
```

- **Java (JVM)**:
  - Strong typing with compiled bytecode execution.
  - Multi-threaded by default; ideal for compute-heavy, AI algorithms, parallel computing, enterprise transactions.
  - Spring / Hibernate frameworks rely on runtime reflection and bytecode manipulation (CGLIB).
- **Node.js**:
  - Dynamically typed JavaScript.
  - Single-threaded event loop utilizing non-blocking asynchronous I/O (via `libuv`).
  - Highly efficient for I/O-intensive operations (real-time chat, streaming, API gateways), but CPU-bound tasks block the event loop unless offloaded to worker threads.
