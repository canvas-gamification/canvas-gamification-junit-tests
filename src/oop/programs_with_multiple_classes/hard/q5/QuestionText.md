# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with three
classes: `Book`, `Bookcase`, and `TestFurniture`. See the requirements below for each class. Note that a `toString`
method has been provided in the `Book` and `Bookcase` classes for you to use.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **year**
    - A `String` called **type**
- Constructors:
    - A `public Book(String, int)` constructor which initializes the **year** field with the passed integer and the
      **type** field with the passed String
- Methods:
    - A `public int determineTime()` method which calculates the amount of years since the **year** when the book was
      published

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**
    - A `Book` called **b1**
- Constructors:
    - A `public Bookcase(int, Book)` constructor which initializes the **sizeCapacity** field with the passed integer
      and the **b1** field with the passed Book
- Methods:
    - A `public String determineReplaced()` method which will prompt the user to buy a new book if **b1** was published
      more than five years ago

## TestFurniture Class

- Your `TestFurniture` class will have a `main` method which initializes two `Bookcase` and two `Book` objects, and
  prints out the attributes of each object. Additionally, you should call the bookcase's `determineReplaced()` method
  and print the returned String. Initialize the objects with the values shown in the sample output and print them out.
  Use the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Book b1 = new Book(2005, "HardCover");
  Book b2 = new Book(2019, "SoftCover");
  Bookcase bc1 = new Bookcase(40, b1);
  Bookcase bc2 = new Bookcase(40, b2);
  bc1.determineReplaced();
  bc2.determineReplaced();
  System.out.println("Book 1: " + b1);
  System.out.println("Book 2: " + b2);
  System.out.println("Bookcase 1: " + bc1);
  System.out.println("Bookcase 2: " + bc2);
  System.out.println("Do I need a new book for Bookcase 1? " + bc1.determineReplaced());
  System.out.println("Do I need a new book for Bookcase 2? " + bc2.determineReplaced());
  ```
