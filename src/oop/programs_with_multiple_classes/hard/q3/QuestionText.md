# oop-programs_with_multiple_classes-hard-q3

You want to write a program that models books in a bookcase. To do this, create a Java program with two
classes: `Book` and `Bookcase`. See the requirements below for each class.

## Book Class

Your `Book` class should have the following items:

- Attributes:
    - An `int` called **count**
    - A `String` called **type**
    - Both attributes should not be visible from other classes
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
    - An array of `Book`s called **shelf**
    - Both attributes should not be visible from other classes
- Constructors:
    - A constructor which accepts an int to initialize the **sizeCapacity** attribute and is accessible from other classes.
      This constructor should ensure that the **sizeCapacity** attribute is not set to a negative number by calling the 
      `validate` method. If `validate` returns false, instead set **sizeCapacity** to 0. Then use **sizeCapacity** to
      initialize **shelf** as an empty array.
- Methods:
    - A `validate` method that accepts an `int` and checks if it is negative. If it is, print "Error! Size capacity 
      cannot be negative." and return false. Otherwise, return true.
    - An `addBook` method that accepts a `Book` and places it in the first empty slot of the **shelf** array. If there
      is no empty index, print "The Bookshelf is full." on its own line.
    - A `removeBook` method that accepts an `int` and uses it as an index for the **shelf** array. It should check if
      there is a `Book` at the index. If there is, replace it with **null**, otherwise print "There is nothing here." 
      on its own line.