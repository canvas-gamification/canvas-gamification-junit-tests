# oop-special_class_method-medium-q14

Java question

## Question Text

As an employee of a material processing facility, you are tasked with modelling the facility's functionalities. Using
the requirements below, make a Java class called **Water**.

### Water Class:

Your `Water` class already has the following items:

- Attributes:
    - A `String` called **quality**
    - A `double` called **volume**
    - These are not visible from other classes

- Constructor:
    - a `Water` constructor that is visible to other classes and initializes the **quality** and **volume** attributes
      to `Good` and 1000.0 respectively.

You need to add the following items:

- Methods:
    - a `setVolume` method which accepts a `double` and uses it to set the value of the **volume** attribute.
    - a `getVolume` method which returns the value stored in the **volume** attribute.
    - a `filter` method which subtracts 0.001 from the **volume** and changes the quality to `Filtered`.
    - These methods must be visible from other classes.