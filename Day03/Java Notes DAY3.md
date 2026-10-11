# Java Notes DAY3 – Arrays in Java


## 1. What is an Array?

An array in Java is a **fixed-size collection of elements of the same data type**, stored in contiguous memory locations and accessed using a zero-based index.

Instead of creating multiple separate variables:

```java
int mark1 = 80;
int mark2 = 75;
int mark3 = 90;
int mark4 = 85;
```

We can store them compactly in a single array variable:

```java
int[] marks = {80, 75, 90, 85};

Index:    0    1    2    3
          ↓    ↓    ↓    ↓
marks:  [80] [75] [90] [85]
```

> **In short:** An array stores multiple values of the same type under one name, indexed starting from 0.


## 2. Declaring and Creating an Array

In Java, an array is an **object** on the Heap. Array declaration creates a reference variable on the Stack, while the **new** keyword allocates memory on the Heap.


### Declaration Syntax

```java
dataType[] arrayName;   // Preferred style
dataType arrayName[];   // Alternative C-style
```


### Creation Syntax

```java
int[] marks = new int[5]; // Allocates space for 5 integers
```

**Default values initialized by JVM: **integers = 0, floating-point = 0.0, boolean = false, objects/Strings = null.


## 3. Assigning and Accessing Values

Array elements are accessed using square brackets [index]:

```java
int[] marks = new int[5];

marks[0] = 80;
marks[1] = 75;
marks[2] = 90;
marks[3] = 85;
marks[4] = 95;

System.out.println(marks[2]); // Outputs: 90
```

**Important Exception: **Accessing an invalid index (e.g., marks[5] or marks[-1]) throws **ArrayIndexOutOfBoundsException**. Valid index range is strictly from 0 to (length - 1).


## 4. Direct Array Initialization

Declaration and initialization can be combined in one statement:

```java
int[] marks = {80, 75, 90, 85, 95};

System.out.println("Total subjects: " + marks.length);
System.out.println("First mark: " + marks[0]);
```

> **In short:** The length property (marks.length) gives the number of elements. Notice length is a property (no parentheses), unlike String.length().


## 5. Traversing an Array


### A. Using Standard for Loop

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println("Index " + i + ": " + numbers[i]);
}
```


### B. Using Enhanced for-each Loop

Java provides a clean for-each loop to iterate over all elements directly without indexing:

```java
for (int num : numbers) {
    System.out.println(num);
}
```


## 6. Essential Array Algorithms


### A. Finding Sum and Average

```java
int[] marks = {80, 75, 90, 85, 95};
int sum = 0;

for (int m : marks) {
    sum += m;
}
double avg = (double) sum / marks.length;

System.out.println("Sum = " + sum);         // Sum = 425
System.out.println("Average = " + avg);     // Average = 85.0
```


### B. Finding Largest and Smallest Element

```java
int[] nums = {45, 12, 89, 23, 76};
int max = nums[0];
int min = nums[0];

for (int i = 1; i < nums.length; i++) {
    if (nums[i] > max) max = nums[i];
    if (nums[i] < min) min = nums[i];
}
System.out.println("Max: " + max); // Max: 89
System.out.println("Min: " + min); // Min: 12
```


### C. Linear Search

```java
int[] arr = {10, 20, 30, 40, 50};
int target = 30;
int foundIndex = -1;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        foundIndex = i;
        break;
    }
}
if (foundIndex != -1) {
    System.out.println("Found at index: " + foundIndex);
} else {
    System.out.println("Element not found");
}
```


### D. Reversing an Array In-Place

```java
int[] arr = {1, 2, 3, 4, 5};
int start = 0, end = arr.length - 1;

while (start < end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    start++;
    end--;
}
```


## 7. Two-Dimensional (2D) Arrays (Matrices)

A 2D array is an array of arrays, represented logically as rows and columns:

```java
int[][] matrix = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};

// Logical View:
//          Col 0  Col 1  Col 2
//  Row 0    10     20     30
//  Row 1    40     50     60
//  Row 2    70     80     90

System.out.println(matrix[1][2]); // Output: 60 (Row 1, Column 2)
```


### Traversing a 2D Array

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.println();
}
```


## 8. Memory Model: Stack vs Heap

```java
STACK                            HEAP
┌───────────────┐              ┌───────────────────────────┐
│ marks [ref] ──┼─────────────>│ [80]  [75]  [90]  [85] [95]│
└───────────────┘              │  0     1     2     3    4  │
                               └───────────────────────────┘
```

The reference variable 'marks' lives on the Stack. The actual array elements live together in a single contiguous block on the Heap.


## 9. Quick Summary Table


| Concept | Syntax | Key Characteristic |
| --- | --- | --- |
| Declaration | int[] arr; | Allocates reference variable on Stack |
| Creation | arr = new int[5]; | Allocates default-initialized elements on Heap |
| Indexing | arr[0] to arr[arr.length - 1] | Zero-based; bounds checked at runtime |
| Length | arr.length | Final property, not a method |
| 2D Array | int[][] m = new int[3][3]; | Array of 1D arrays (Row x Column) |

