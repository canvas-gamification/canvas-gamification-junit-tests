# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **year**
    - A `String` called **type**
- Constructors:
    - A constructor which accepts an `int` to initialize the **year** attribute and a `String` to
      initialize the **type** attribute (in that order)
    - This constructor should be accessible from other classes
- Methods:
    - A method called `determineTime` that receives no input and returns an `int`. It should calculate the amount of 
      years since the **year** when a book was published using the current year. This method should be accessible from 
      other classes.

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**
    - An array of `Book` objects called **books**
- Constructors:
    - A constructor which accepts an `int` to initialize the **sizeCapacity** attribute and an array of `Book` objects to
      initialize the **books** attribute (in this order). If the number of `Book`s in the array exceeds **sizeCapacity**,
      initialize the **books** array with the first x `Book`s where x is **sizeCapacity**.
        - This constructor should be accessible from other classes.
- Methods:
    - A method called `determineReplacement` that receives no input and returns a `String`. It should prompt the user to 
      buy a new book if one of the **books** was published more than five years ago by either returning
      "You have enough new books!" or "Time to buy a new book!".
        - This method should be accessible from other classes
    