# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **year**
    - A `String` called **type**
- Constructors:
    - A constructor which accepts a String to initialize the **type** field and an int to
      initialize the **year** field (in that order)
    - This constructor should be accessible from other classes
- Methods:
    - A method called `determineTime`
        - It should take no input and return an int
        - Its purpose is to calculate the amount of years since the **year** when a book was
          published
        - This method should be accessible from other classes

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**
    - A `Book` called **b1**
- Constructors:
    - A constructor which accepts an int to initialize the **sizeCapacity** field and a Book to initialize the **b1**
      field (in this order)
        - This constructor should be accessible from other classes
- Methods:
    - A method called `determineReplaced`
        - It should take no input and return a String
        - Its purpose is to prompt the user to buy a new book if **b1** was published more than five years ago
        - This method should be accessible from other classes
