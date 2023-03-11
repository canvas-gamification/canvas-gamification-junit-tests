# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with three
classes: `Book`, `Bookcase`, and `TestFurniture`. See the requirements below for each class. Note that a `toString`
method has been provided in the `Book` and `Bookcase` classes for you to use.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **count**
    - A `String` called **type**
- Constructors:
    - A `public Book(String, int)` constructor which initializes the **count** field with the passed integer and the
      **type** field with the passed String

## Bookcase Class

Your `Bookcase` class should have the following items:

- Attributes:
    - A `int` called **sizeCapacity**
- Constructors:
    - A `public Bookcase(int)` constructor which initializes the **sizeCapacity** field with the passed integer

## TestFurniture Class

- Your `TestFurniture` class will have a `main` method which initializes a `Bookcase` and two `Book` objects, and prints
  out the attributes of each object. Initialize the objects with the values shown in the sample output and print them
  out. Use the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Book 1: Book{count=1, type='HardCover'}
  Book 2: Book{count=1, type='SoftCover'}
  Bookcase: Bookcase{sizeCapacity=20}
  ```
