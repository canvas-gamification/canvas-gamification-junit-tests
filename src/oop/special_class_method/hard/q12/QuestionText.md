# oop-special_class_method-hard-q12

Java question

## Question Text

You are developing a program that teaches people about the physical traits of a variety of human-made objects. Write a 
Java class called **Laptop** to model an object using the requirements below:

### Laptop Class:

Your `Laptop` class must have the following items:

- Attributes:
    - An `int` called **yearMade**
    - A `String` called **colour**
    - These should not be visible from other classes

- Constructor:
    - a `Laptop` constructor that is visible to other classes and accepts an `int` and a `String` and uses them to initialize
      the **yearMade** and **colour** attributes.

- Methods:
    - a `setYearMade` method which accepts an `int` and uses it to set the value of the **yearMade** attribute and 
      should not return anything.
    - a `getYearMade` method which returns the value stored in the **yearMade** attribute.
    - a `setColour` method which accepts a `String` and uses it to set the value of the **colour** attribute and should
      not return anything.
    - a `getColour` method which returns the value stored in the **colour** attribute
    - a `toString`  method which returns a `String` of the format "The x Cup was made in y" where x is **colour**, y is
      **yearMade**.
    - These methods must be visible from other classes.