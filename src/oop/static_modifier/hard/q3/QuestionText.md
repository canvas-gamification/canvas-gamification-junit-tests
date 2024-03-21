# oop-static_modifier-hard-q3

- Question Type: Java question

## Question Text

The candy stores in Kelowna have banded together to give away a new flavour of gummy. Write a Java class called
`CandyStore` to keep track of a store's gummy supply using the requirements below. Then, write a class called Test to test
`CandyStore` using the next set of requirements below.



## CandyStore Class

Your `CandyStore` class must have the following requirements:

- Attributes:
    - Note that all attributes should not be visible from another class
    - A _static_ `int` called **gummies**. This represents the number of gummies of the all `CandyStore` objects,
      and should be set initially to 100 without having to call the constructor.
    - A `String` called **name**

- Constructors:
    - A constructor that is accessible from other methods, and accepts a `String` as a parameter to set the **name**
      attribute of the object.

- Methods:
    - Note that all methods in this class should be visible from another class
    - An `award` method that receives an `int` as a parameter. If there are more **gummies** available than the passed
      value it should decrease that value from the **gummies** attribute. Then it should print the number of remaining
      gummies in format of "There are x more to give away after the y award", where x is the value of the **gummies**
      attribute after the subtraction and y is the value of **name**.

## Test Class

Your `Test` class must have the following items:

- Main method:
    - A `main` method that initializes three `CandyStore` objects with names: "Corner Jack", "Best Deals in Kelowna", and
      "The Apple Mall". Then use the **award** method to give away 20 gummies from the first store, 10 gummies from the
      second and finally 15 gummies from the third.