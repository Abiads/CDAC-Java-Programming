# Assignment 2: Control Flow & Conditional Statements
## Module: Decision Making (if, if-else, if-else-if ladder) & Static Methods

This assignment covers decision-making statements and method modularization in Java. All programs have runnable Eclipse implementations under `com.cdac.assignments.day02`.

---

### Problems

#### 1. Electricity Bill Calculation (`if-else-if`)
- **Objective**: Calculate an electricity bill based on tiered cumulative units consumed.
- **Slabs**:
  - `0 – 100 units`: ₹2 per unit
  - `101 – 200 units`: ₹3 per unit
  - `201 – 300 units`: ₹5 per unit
  - `Above 300 units`: ₹7 per unit
- **Method**: `static double calculateBill(int units)`
- **Class**: `Q01_ElectricityBill.java`

#### 2. Student Grade Calculation (`if-else-if`)
- **Objective**: Calculate a student's grade based on marks.
- **Grading Scale**:
  - `90 – 100`: Grade A
  - `75 – 89`: Grade B
  - `60 – 74`: Grade C
  - `50 – 59`: Grade D
  - `Below 50`: Grade F
- **Method**: `static String calculateGrade(int marks)`
- **Class**: `Q02_StudentGradeCalculation.java`

#### 3. Product Discount Calculation (`if-else-if`)
- **Objective**: Calculate the final payable price after applying discount based on purchase amount.
- **Discount Slabs**:
  - `₹10,000 and above`: 20% discount
  - `₹5,000 – ₹9,999.99`: 10% discount
  - `₹2,000 – ₹4,999.99`: 5% discount
  - `Below ₹2,000`: No discount
- **Method**: `static double calculateFinalPrice(double price)`
- **Class**: `Q03_ProductDiscount.java`

#### 4. Largest of Two Numbers (`if-else`)
- **Objective**: Compare two numbers and return the larger value (or either if equal).
- **Method**: `static int findLargest(int a, int b)`
- **Class**: `Q04_LargestOfTwoNumbers.java`

#### 5. Voting Eligibility (`if-else`)
- **Objective**: Check if a person is 18 years or older to vote.
- **Method**: `static boolean isEligible(int age)`
- **Class**: `Q05_CheckVotingEligibility.java`

#### 6. Employee Salary Calculation (`if-else`)
- **Objective**: Calculate final salary by adding HRA based on basic salary threshold.
- **Rules**:
  - Basic salary $\ge ₹50,000 \implies$ 20% HRA
  - Basic salary $< ₹50,000 \implies$ 10% HRA
- **Method**: `static double calculateSalary(double basicSalary)`
- **Class**: `Q06_EmployeeSalaryCalculation.java`

#### 7. Temperature Conversion & Threshold Check (`if`)
- **Objective**: Convert Celsius to Fahrenheit and alert if above 100°F.
- **Formula**: $F = (C \times 9 / 5) + 32$
- **Method**: `static double convertTemperature(double celsius)`
- **Class**: `Q07_TemperatureConversion.java`

#### 8. Simple Calculator (`if-else-if`)
- **Objective**: Perform basic arithmetic (`+`, `-`, `*`, `/`) with division-by-zero protection.
- **Method**: `static double calculate(double num1, double num2, char operator)`
- **Class**: `Q08_SimpleCalculator.java`

#### 9. Bus Ticket Fare (`if-else-if`)
- **Objective**: Determine ticket fare based on passenger age category.
- **Fare Matrix**:
  - `Below 5 years`: Free (₹0)
  - `5 – 12 years`: ₹20
  - `13 – 59 years`: ₹40
  - `60 years and above`: ₹25
- **Method**: `static int calculateFare(int age)`
- **Class**: `Q09_BusTicketFare.java`

#### 10. Mobile Data Usage Charge (`if-else-if`)
- **Objective**: Calculate mobile data bill based on GB consumed.
- **Usage Slabs**:
  - `Up to 1 GB`: ₹50
  - `> 1 GB up to 5 GB`: ₹100
  - `> 5 GB up to 10 GB`: ₹200
  - `Above 10 GB`: ₹350
- **Method**: `static double calculateCharge(double dataUsedGB)`
- **Class**: `Q10_MobileDataUsage.java`
