# Assignment 3: Loops, Iteration & Array Manipulation
## Module: Iterative Algorithms (while, for, do-while) & 1D/2D Arrays

This assignment covers foundational iterative problem solving, mathematical loops, and array manipulations in Java. All programs have runnable Eclipse implementations under `com.cdac.assignments.day03`.

---

### Problems

#### 1. Sum of First N Natural Numbers
- **Objective**: Accept an integer $N$ and compute the sum of the first $N$ natural numbers using a loop.
- **Formula Check**: Verify that the iterative result matches $\frac{N(N + 1)}{2}$.
- **Class**: `Q01_SumOfNaturalNumbers.java`

#### 2. Factorial Calculation
- **Objective**: Accept a non-negative integer $N$ and calculate its factorial ($N!$) using a loop.
- **Constraints**: Handle $0! = 1$ and reject negative inputs with an informative error message.
- **Class**: `Q02_FactorialCalculation.java`

#### 3. Prime Number Check
- **Objective**: Accept an integer and determine whether it is a prime number.
- **Optimization**: Check divisors up to $\sqrt{N}$ ($O(\sqrt{N})$ complexity).
- **Class**: `Q03_PrimeNumberCheck.java`

#### 4. Fibonacci Series
- **Objective**: Accept $N$ and print the first $N$ numbers of the Fibonacci sequence ($0, 1, 1, 2, 3, 5, 8, \dots$).
- **Class**: `Q04_FibonacciSeries.java`

#### 5. Reverse an Integer & Palindrome Check
- **Objective**: Reverse the digits of an integer using modulo (`%`) and division (`/`), then verify if the original number equals its reverse.
- **Class**: `Q05_ReverseAndPalindromeNumber.java`

#### 6. Array Sum and Average
- **Objective**: Read $N$ elements into an integer array, then calculate and display their total sum and average.
- **Class**: `Q06_ArraySumAndAverage.java`

#### 7. Find Minimum and Maximum in an Array
- **Objective**: Find both the smallest and largest elements in an array in a single traversal pass ($O(N)$).
- **Class**: `Q07_ArrayMinMax.java`

#### 8. Linear Search
- **Objective**: Search for a target key in an array. Display its 0-based index if found, or `-1` if not found.
- **Class**: `Q08_LinearSearch.java`

#### 9. Bubble Sort
- **Objective**: Sort an integer array in ascending order using the Bubble Sort algorithm with an early-exit optimization flag.
- **Class**: `Q09_BubbleSort.java`

#### 10. Matrix Addition (2D Arrays)
- **Objective**: Input two 2D matrices of dimensions $R \times C$, perform element-wise matrix addition, and display the resultant matrix in tabular grid format.
- **Class**: `Q10_MatrixAddition.java`
