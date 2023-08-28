# oop-special_class_method-hard-q8

### Circle Class:

Your `Circle` class must have the following items:

- Attributes :
    - A `double` attribute named **radius** which is not accessible from other classes
    - A `String` attribute named **colour** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a `double` and a `String` to initialize the
      **radius** and **colour** attributes.

- Methods:
    - a `setRadius` method which accepts a `double` value, updates the **radius** attribute with it, and is accessible
      from other classes
    - a `getRadius` method which is accessible from other classes and returns the value of the **radius** attribute
    - a `setColour` method which accepts a `String` value, updates the **colour** attribute with it, and is accessible
      from other classes
    - a `getColour` method which is accessible from other classes and returns the value of the **colour** attribute
    - a `toString` method which returns a String of the information about the `Circle` class of the form
      `"I have a x radius and my colour is y"` where x is the value of **radius** attribute and y is the
      value of **colour** attribute

### Test Class:

Your `Test` class will have a main method which initializes a `Circle` of **radius** 3.75 and **colour** "Red". Then,
print the toString for this class.