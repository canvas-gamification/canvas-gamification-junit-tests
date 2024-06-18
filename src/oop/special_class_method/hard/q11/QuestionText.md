# oop-special_class_method-hard-q11

## Question Text

You are making a game that has many strange and scary-looking characters. Write a Java class called **Alien** to model a creature in the game using the requirements below:

### Alien Class:

Your `Alien` class must have the following items:

- Attributes:
    - A `int` called **numEyes**
    - A `String` called **colour**
    - These are not visible from other classes

- Constructor:
    - a `Alien` constructor that is visible to other classes and takes an `int` and a `String` as input to
      initialize the **numEyes** and **colour** attributes.

- Methods:
    - a `getNumEyes` method which returns the value stored in the **numEyes** attribute
    - a `getColour` method which returns the value stored in the **colour** attribute
    - a `toString` method which returns a `String` in the format of "The x Alien has y eyes" where x is the value of 
      **colour** and y is the value of **numEyes**
    - These methods must be visible from other classes.