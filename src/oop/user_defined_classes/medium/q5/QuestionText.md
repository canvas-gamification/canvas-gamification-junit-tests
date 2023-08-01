# oop-user_defined_classes-medium-q5

## Java

So many things in life cost money, and you need to put that money somewhere. Make a Java class called `Bank` to model a bank to deposit your money.

## Bank

The `Bank` class you are given has the following items:

- Attributes:
    - A `double` called **fee** that is not accessible from other classes

You need to add the following items:

- Constructor:
    - A constructor, which is accessible from other classes, to initialize the **fee** attribute to 5.25.
- Methods:
    - Create the method **increase**, which is accessible from other classes and takes an integer for a number of months
      from today to calculate the future fee, and returns the value as a double. The estimation is calculated using 
      the formula future fee = current fee * (number of months in the future + 0.95).
