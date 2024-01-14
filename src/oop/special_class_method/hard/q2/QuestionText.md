# oop-special_class_method-hard-q2

### Glasses Class:

To practice your Java skills, you decide to make a class to model a household object. Create a class called `Glasses` to model a drinking class with the requirements below:

- Attributes:
    - a `double` attribute named **size** which is not accessible from other classes
    - a `String` attribute named **type** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a `double` and a `String` value to initialize the
      **size** and **type** attributes.
    - You should initialize the **size** attribute as 10 times the `double` input.

- Methods:
    - a `setSize` method which accepts a `double` value, updates the **size** attribute with it and is accessible from
      other classes
    - a `getSize` method which is accessible from other classes and returns the value of the **size** attribute
    - a `setType` method which accepts a `String` value, updates the **type** attribute with it and is accessible
      from other classes
    - a `getType` method which is accessible from other classes and returns the value of the **type** attribute
    - Note that the return type for the setter methods must be void
    - a `toString` method which returns a String of the information about the `Glasses` class of the form
      `"These glasses have a size of x, and are type y"` where x is the value of the size attribute and y is the value of the type attribute.

### Test Class:

Your `Test` class will have a main method which initializes a `Glasses` object of **size** 7.5 and **type** "Long". Then, print the toString for this object.
