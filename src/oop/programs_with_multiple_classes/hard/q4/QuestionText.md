# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **year** that represents when the book was published, which is not accessible from other classes
    - A `String` called **type**, which is not accessible from other classes
- Constructors:
    - A constructor which accepts a `String` to initialize the **type** attribute and an `int` to initialize the **year**
      attribute (in this order)
        - This constructor should be accessible from other classes
- Methods:
    - A method called `howManyYears` that takes no input and returns an `int`. It should calculate the amount of years 
      since the **year** when a book was purchased using the current year. This method should be accessible from other 
      classes.

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**, which is not accessible from other classes
    - An array of `Book` called **books**, which is not accessible from other classes
- Constructors:
    - A constructor which accepts an `int` to initialize the **sizeCapacity** attribute and an array of `Book` to 
      initialize the **books** attribute (in this order)
        - This constructor should be accessible from other classes
- Methods:
    - A method called `setBooks` which receives an array of `Book` as a parameter and sets the value of **books** to
      the array. This method should be accessible from other classes.
    - A method called `sellBook` which receives an `int` representing the index of the book to be sold. If the book
      was purchased twenty years ago or longer, print "No, this book is precious to me." Otherwise, set the value
      of the index to null.
