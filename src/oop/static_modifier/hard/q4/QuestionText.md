# oop-static_modifier-hard-q4

- Question Type: Java question

## Question Text

There is a limited stock of wood in a carpentry shop. Write a Java class called `Bed` to keep track of the wood usage in 
projects using the requirements below. Then write a Java class called `TestWarehouse` which tests the `Bed` class using 
the second set of requirements below.

## Bed Class

Your `Bed` class must have the following requirements:

- Attributes:
    - A _static_ `int` called **woodBeams**. This represents the total number of wood beams available for making `Bed`
      objects, and should be set initially to 100 without having to call the constructor. Note that it should not be
      visible from other classes.
    - An `int` called **numBeams** which is the amount of wood required to make the `Bed` Object. Note that it should not be
      visible from other classes.

- Constructors:
    - A constructor that is accessible from other methods, and accepts an `int` as a parameter to set the **numBeams**
      attribute of the object.

- Methods:
    - Note that all methods in this class should be visible from another class
    - A `makeFurniture` method which return false if the **numBeams** value is more than **woodBeams**, meaning that the
      `Bed` object cannot be made, or subtract the **numBeams** value from the **woodBeams** and return true.

## TestWarehouse Class

Your `TestWarehouse` class must have the following items:

- Main method:
    - A `main` method which initializes an array of 5 `Bed` objects with **numBeams** of each of them being 24, then go
      through them and attempt to make one of each object using `makeFurniture` method. Finally, print the number of beds made in format
      of: "x pieces of furniture were made" where x is the number of furniture made.