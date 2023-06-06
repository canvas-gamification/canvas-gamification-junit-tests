# oop-user_defined_classes-medium-q5

## Java

So many things in life cost money. Make a Java class called `Bank` that has one attribute
called **fee** and a default constructor that initializes the value to a constant. This class
also has another method called **increase** that takes as input the number of months
from today so that it can calculate and return how much increase there is in the fee in the
future.

## Bank

The `Bank` class you are given has the following items:

- Attributes:
    - A `double` called **fee** that is not accessible from other lcasses

You need to add the following items:

- Constructor:
    - A constructor, which is accessible from other classes, to initialize the **fee** attribute to 5.25.
- Methods:
    - Create the method **increase**, which is accessible from other classes, that takes an integer for number of months
      from today and calculate the future fee. The estimation is calculated using formula
      future fee = current fee * (number of moths in the future + 0.95).