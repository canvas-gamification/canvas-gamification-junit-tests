# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **year**, which is not accessible from other classes
    - A `String` called **type**, which is not accessible from other classes
- Constructors:
    - A constructor which accepts a `String` to initialize the **type** attribute and an `int` to initialize the **year**
      attribute (in this order)
        - This constructor should be accessible from other classes
- Methods:
    - A method called `howManyYears`
        - It should take no input and return an `int`
        - It should calculate the amount of years since the **year** when a book was published using the 
          current year
        - This method should be accessible from other classes

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**, which is not accessible from other classes
    - A `Book` called **b1**, which is not accessible from other classes
- Constructors:
    - A constructor which accepts an `int` to initialize the **sizeCapacity** attribute and a `Book` to initialize the **b1**
      attribute (in this order)
        - This constructor should be accessible from other classes
