# Sessions 11 & 12: Java Concurrency & Multithreading

## 1. Concurrency vs. Multithreading
- **Multitasking**: Executing multiple tasks or processes concurrently by the CPU.
- **Multithreading**: Lightweight sub-processes within the same application process sharing memory space (heap).
- **Advantages**: Improved CPU utilization, responsive UI, parallel computing.
- **Issues**: Race conditions, deadlocks, thread starvation, priority inversion.

---

## 2. Thread Lifecycle (States)
In Java, a thread transitions through the following `Thread.State` lifecycle:
```
           [NEW]
             │  start()
             ▼
        [RUNNABLE]  ◄───────────────────────────┐
         │      ▲                                │
         │      │ Yield / Scheduler slice        │
         │      └──────────────────────┐         │
         ▼                             │         │
    [BLOCKED / WAITING / TIMED_WAITING] ────────┘
    (Waiting for lock, wait(), sleep(ms))
         │
         ▼ run() completes
    [TERMINATED]
```

---

## 3. Creating Threads in Java

### Approach 1: Implementing `Runnable` (Recommended)
Preferred because Java does not support multiple class inheritance; leaves class open to extend another base class.
```java
Runnable task = () -> {
    System.out.println("Running in thread: " + Thread.currentThread().getName());
};
Thread thread = new Thread(task, "Worker-1");
thread.start();
```

### Approach 2: Extending `Thread` Class
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + getName());
    }
}
MyThread t = new MyThread();
t.start(); // Note: call start(), NOT run()!
```

---

## 4. Thread Groups & Thread Methods
- **`Thread.sleep(millis)`**: Temporarily pauses thread execution without releasing locks.
- **`thread.join()`**: Waits for the target thread to complete execution before the calling thread continues.
- **`thread.setPriority(1 to 10)`**: Hint to OS thread scheduler (`Thread.MIN_PRIORITY = 1`, `NORM_PRIORITY = 5`, `MAX_PRIORITY = 10`).
- **`ThreadGroup`**: Groups multiple threads into a single administrative unit to manage interrupts or priorities en masse.

---

## 5. Synchronization & Race Conditions
When multiple threads access shared mutable data simultaneously without coordination, data corruption (a **Race Condition**) occurs.

### Synchronized Methods
Acquires the intrinsic lock (monitor) of the `this` instance:
```java
public synchronized void deposit(double amount) {
    balance += amount;
}
```

### Synchronized Statements / Blocks
Provides finer-grained locking, preventing unnecessary bottlenecks:
```java
public void transfer(Account target, double amount) {
    synchronized (this) {
        if (balance >= amount) {
            balance -= amount;
            target.deposit(amount);
        }
    }
}
```

### Inter-Thread Communication (`wait`, `notify`, `notifyAll`)
Must be called from within a `synchronized` context:
- `wait()`: Releases monitor lock and waits until notified.
- `notify()`: Wakes up a single waiting thread.
- `notifyAll()`: Wakes up all waiting threads.
