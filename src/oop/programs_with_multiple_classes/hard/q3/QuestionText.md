# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **count**
    - A `String` called **type**
- Constructors:
    - A constructor which accepts a String to initialize the **count** attribute and an int to initialize the
      **type** attribute and is accessible from other classes
- Methods:
    - An `incrementBookCount` method that adds one to the **count**. This method should return the incremented count.

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**
- Constructors:
    - A constructor which accepts an int to initialize the **sizeCapacity** attribute and is accessible from other classes.
      This constructor should ensure that the **sizeCapacity** attribute is not set to a negative number. If it is, print "Error!
      Size capacity cannot be negative." instead of setting it to the passed parameter.
