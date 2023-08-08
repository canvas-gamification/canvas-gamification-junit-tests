# oop-special_class_method-medium-q12

## Question Text

Complete a Java class called **Shirt** with a constructor that initializes the attributes. Furthermore, the attribute called
**size** cannot be modified from outside the class, but it can be accessed through an accessor method. The class has
another attribute called **yearMade** that cannot be modified or accessed from outside the class.

### Shirt Class:

Your `Shirt` class already has the following items:

- Attributes:
    - An `int` called **size**
    - An `int` called **yearMade**
    - These are not visible from other classes

- Constructor:
    - a `Shirt` constructor that is visible to other classes and accepts two `int` values and uses them to initialize
      the **size** and **yearMade** attributes.

You need to add the following items:

- Methods:
    - a `displaySize` method which return a `String` like `The size is x` where x is the value of **size** only if the
      value of **yearMade** is greater than 2000.
    - a `getSize` method which returns the value stored in the **size** attribute