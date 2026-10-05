# Assignment 4: Classes and Objects
## Module: Object-Oriented Programming (OOP) Fundamentals & State Encapsulation

This assignment is transcribed from `Java Assignment 4-classes and objects.docx`. All programs have corresponding runnable Eclipse implementations under `com.cdac.assignments.day04`.

---

### Problems

#### 1. Employee Salary Calculation
- **Objective**: Create an `Employee` class representing corporate workforce salary modeling.
- **Data Members**:
  - Employee ID (`empId`)
  - Employee Name (`empName`)
  - Basic Salary (`basicSalary`)
  - HRA (`hra`)
  - DA (`da`)
- **Methods**:
  - `read()` – to read employee details (Scanner / parameter overloading).
  - `calculateSalary()` – to calculate gross salary.
  - `display()` – to display employee details and gross salary.
- **Formula**:
  $$\text{Gross Salary} = \text{Basic Salary} + \text{HRA} + \text{DA}$$
- **Files**: [`Employee.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Employee.java), [`Q01_EmployeeSalary.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Q01_EmployeeSalary.java)

---

#### 2. Bank Account Management
- **Objective**: Create a `BankAccount` class modeling basic ledger operations with state mutations.
- **Data Members**:
  - Account Number (`accountNumber`)
  - Customer Name (`customerName`)
  - Balance (`balance`)
- **Methods**:
  - `read()` – to read account details and initial balance.
  - `deposit(double amount)` – to deposit an amount into the account with positive value verification.
  - `withdraw(double amount)` – to withdraw an amount if sufficient balance is available.
  - `display()` – to display account details and current balance.
- **Requirement**: Instantiate an object and execute one deposit and one withdrawal operation.
- **Files**: [`BankAccount.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/BankAccount.java), [`Q02_BankAccountManagement.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Q02_BankAccountManagement.java)

---

#### 3. Product Billing
- **Objective**: Create a `Product` class calculating invoice line items.
- **Data Members**:
  - Product ID (`productId`)
  - Product Name (`productName`)
  - Unit Price (`price`)
  - Quantity (`quantity`)
- **Methods**:
  - `read()` – to read product details.
  - `calculateBill()` – to calculate total bill amount.
  - `display()` – to display product details and total bill amount.
- **Formula**:
  $$\text{Total Amount} = \text{Price} \times \text{Quantity}$$
- **Requirement**: Instantiate an object of the class and display the bill.
- **Files**: [`Product.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Product.java), [`Q03_ProductBilling.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Q03_ProductBilling.java)

---

#### 4. Electricity Bill Calculation
- **Objective**: Create an `ElectricityBill` class computing tiered utility tariffs in an object-oriented structure.
- **Data Members**:
  - Consumer Number (`consumerNumber`)
  - Consumer Name (`consumerName`)
  - Number of Units (`units`)
- **Methods**:
  - `read()` – to read consumer details and units consumed.
  - `calculateBill()` – to calculate electricity bill according to tiered rates:
    - First 100 units: ₹2 per unit
    - Next 100 units (101–200): ₹3 per unit
    - Above 200 units (> 200): ₹5 per unit
  - `display()` – to display consumer details and bill amount.
- **Files**: [`ElectricityBill.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/ElectricityBill.java), [`Q04_ElectricityBillCalculation.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Q04_ElectricityBillCalculation.java)

---

#### 5. Movie Ticket Booking
- **Objective**: Create a `MovieTicket` class modeling multiplex ticketing transactions.
- **Data Members**:
  - Customer Name (`customerName`)
  - Movie Name (`movieName`)
  - Number of Tickets (`numberOfTickets`)
  - Ticket Price (`ticketPrice`)
- **Methods**:
  - `read()` – to read customer and ticket details.
  - `calculateAmount()` – to calculate total ticket amount.
  - `display()` – to display booking details and total amount.
- **Formula**:
  $$\text{Total Amount} = \text{Number of Tickets} \times \text{Ticket Price}$$
- **Files**: [`MovieTicket.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/MovieTicket.java), [`Q05_MovieTicketBooking.java`](file:///C:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/assignments/day04/Q05_MovieTicketBooking.java)
