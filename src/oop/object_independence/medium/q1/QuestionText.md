# oop-object_independence-medium-q1

## Question Info

- Question type: Parsons

## Question Text

You are writing a program that keeps track of where your money goes. Make a class called `BankAccount` to do this, and
another class called `TestAccount` to test it using the requirements below.

### BankAccount Class

Your `BankAccount` class must have the following items:

- Attributes:
    - A `double` called **currentBalance**
    - A `long` called **accountNumber**
    - Note that neither of these attributes should be visible from another class

- Constructors:
    - A single constructor with the parameters `(double, long)` that initalzies the **currentBalance** and **
      accountNumber** fields
    - This constructor should be visible from another class

- Methods:
    - A method called `deposit`, which accepts the parameter `double amount` and adds the amount to the
      **currentBalance** field
    - A method called `withdraw`, which accepts the parameter `double amount` and subtracts the amount from the
      **currentBalance** field if the **currentBalance** is greater than or equal to the amount
    - A method called `listBalance`, which prints out the string "Account No. **x** currently has a balance of $**y**"
      where **x** is the **accountNumber** of the account and **y** is the **currentBalance** of the account
    - Note that all of these methods should be accessible from another class

### TestAccount Class

Your `TestAccount` class must have the following items:

- Methods:
  - A `main` method which initializes two bank account objects, one with a **currentBalance** of 100.0 and 
  **accountNumber** of 123456789 and the other with a **currentBalance** of 0.00 and **accountNumber** of 123456790.
  In the second account, call the `desposit` method and add $400 to the account. Finally, call the `listBalance` method
  on both accounts to print out the information about the account. The output is as follows:
  ```
    Account No. 123456789 currently has a balance of $100.0
    Account No. 123456790 currently has a balance of $400.0
  ```
