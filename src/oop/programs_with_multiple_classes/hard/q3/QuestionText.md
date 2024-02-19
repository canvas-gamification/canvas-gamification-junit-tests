# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **count**
    - A `String` called **type**
- Constructors:
    - A constructor which accepts an `int` to initialize the **count** attribute and a `String` to initialize the
      **type** attribute and is accessible from other classes
- Methods:
    - An `incrementBookCount` method that increments the value of **count** by 1. This method should then return the 
      incremented count.

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - An `int` called **sizeCapacity**
- Constructors:
    - A constructor which accepts an int to initialize the **sizeCapacity** attribute and is accessible from other classes.
      This constructor should ensure that the **sizeCapacity** attribute is not set to a negative number by calling the 
      `validate` method. If `validate` returns false, instead set **sizeCapacity** to 0.
- Methods:
    - A `validate` method that accepts an `int` and checks if it is negative. If it is, print "Error! Size capacity 
      cannot be negative." and return false. Otherwise, return true.