# oop-special_class_method-medium-q10

## Question Type

Java

## Question Text

Each store should have an inventory system to alert store managers when an item is low in stock so they can order 
replacements. Using the requirements below, write a Java class called **Shoe** to keep track of the store's shoe stock.

### Shoe Class:

Your `Shoe` class already has the following items:

- Attributes:
    - An `int` called **size**
    - A `String` called **colour**
    - These are not visible from other classes

- Constructor:
    - a `Shoe` constructor that is visible to other classes and accepts an `int` and a `String` and uses it to
      initialize the **size** and **colour** attributes respectively.

You need to add the following items:

- Methods:
    - a `setSize` method which accepts an `int` and uses it to set the value of the **size** attribute. It should not
      return anything.
    - a `getSize` method which returns the value stored in the **size** attribute
    - a `setColour` method which accepts a `String` and uses it to set the value of the **colour** attribute. It should
      not return anything.
    - a `getColour` method which returns the value stored in the **colour** attribute.
    - a `toString` method which returns the string `The size of this shoe is x and its colour is y` where x is
      the value of **size** and y is the value of **colour**.
    - These methods must be visible from other classes.