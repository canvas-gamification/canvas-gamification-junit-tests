# oop-special_class_method-medium-q9

### Car Class:

Your `Car` class already has the following items:

- Attributes:
    - An `String` called **maker**
    - An `double` called **topSpeed**
    - These are not visible from other classes

You need to add the following items:

- Constructor:
    - a `Car` constructor that is visible to other classes and accepts a `String` and a `double` and uses it to initialize the
      **maker** and **topSpeed** attributes.

- Methods:
    - a `getMaker` method which returns the value stored in the **maker** attribute
    - a `getTopSpeed` method which returns the value stored in the **topSpeed** attribute
    - a `toString` method which return a `String` of the object information with the format
      `"I was made by x with top speed of y"` where x is the value of **maker** and y is the value of **topSpeed**