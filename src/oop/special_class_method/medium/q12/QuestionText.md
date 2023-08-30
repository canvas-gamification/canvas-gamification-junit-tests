# oop-special_class_method-medium-q12

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
      value of **yearMade** is greater than 2000. Otherwise it should print `This shirt is no longer carried`.
    - a `getSize` method which returns the value stored in the **size** attribute