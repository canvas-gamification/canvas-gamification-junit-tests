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
    - A constructor which accepts a String to initialize the **type** field and an int to initialize the **year**
      field (in this order)
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

## TestFurniture Class

- Your `TestFurniture` class will have a `main` method which initializes a `Bookcase` and two `Book` objects, and prints
  out the attributes of each object. Additionally, you should call each book's `determineTime()` method and print the
  returned integer. Initialize the objects with the values shown in the sample output and print them out. Use
  the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Book 1: Book{year=2005, type='LeatherBound'}
  Book 2: Book{year=2018, type='EPub'}
  Bookcase: Bookcase{sizeCapacity=20, b1=Book{year=2005, type='LeatherBound'}}
  Years since Book 1 was published: 18
  Years since Book 2 was published: 5
  ```
