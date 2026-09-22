# Assignment 1: Basic Java Programs
## Module: Data Types, Variables, Operators & Control Statements

This assignment is transcribed from `Day01/Day01/Java Assignment 1.docx`. All programs have corresponding runnable Eclipse templates in the project under `com.cdac.assignments.day01`.

---

### Part A: Data Types, Variables and Operators

#### 1. Arithmetic Operations
- **Objective**: Declare two integer variables and perform addition, subtraction, multiplication, division, and remainder operations.
- **Expected Output Format**:
  ```
  First Number  = 20
  Second Number = 6
  Addition       : 20 + 6 = 26
  Subtraction    : 20 - 6 = 14
  Multiplication : 20 * 6 = 120
  Division       : 20 / 6 = 3
  Remainder      : 20 % 6 = 2
  ```

#### 2. Area and Circumference of a Circle
- **Objective**: Store the radius of a circle in a variable and calculate its area and circumference.
- **Formulas**:
  - $\text{Area} = \pi \times r^2$
  - $\text{Circumference} = 2 \times \pi \times r$
  - *(Use `Math.PI`)*
- **Sample Input**: Radius $r = 7.5$

#### 3. Simple Interest Calculation
- **Objective**: Accept principal amount ($P$), rate of interest ($R$), and time ($T$) using variables and calculate simple interest and total amount.
- **Formulas**:
  - $\text{Simple Interest} = \frac{P \times R \times T}{100}$
  - $\text{Total Amount} = P + \text{Simple Interest}$
- **Sample Input**: $P = 50000$, $R = 7.5\%$, $T = 3\text{ years}$

#### 4. Temperature Conversion
- **Objective**: Convert temperature from Celsius to Fahrenheit.
- **Formula**:
  - $F = (C \times 9 / 5) + 32$
- **Sample Input**: $C = 37.0^\circ\text{C}$ (Human body temperature)

#### 5. Calculate Total and Average
- **Objective**: Store marks of three subjects in variables and calculate the total and average marks.
- **Sample Input**: Subject 1 = 85, Subject 2 = 78, Subject 3 = 92

---

### Part B: Control Statements (Decisions)

#### 6. Even or Odd
- **Objective**: Accept an integer and check whether the number is even or odd using `if-else`.
- **Logic**: A number $N$ is even if $N \pmod 2 == 0$; otherwise odd.

#### 7. Positive, Negative or Zero
- **Objective**: Accept an integer and check whether it is positive, negative, or zero using `if` and `else-if`.

#### 8. Largest of Two Numbers
- **Objective**: Accept two numbers and find the larger number using `if-else`. If both numbers are equal, display an appropriate message.

#### 9. Voting Eligibility
- **Objective**: Accept a person's age and check whether the person is eligible to vote.
- **Rule**:
  - $\text{Age} \ge 18 \implies \text{Eligible}$
  - $\text{Age} < 18 \implies \text{Not Eligible}$

#### 10. Student Result
- **Objective**: Accept marks of a student and check whether the student has passed or failed.
- **Rule**:
  - $\text{Marks} \ge 40 \implies \text{Pass}$
  - $\text{Marks} < 40 \implies \text{Fail}$
