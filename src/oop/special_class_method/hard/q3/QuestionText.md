# oop-special_class_method-hard-q3

## Question Text

You are writing a Java program that models household furniture and objects. Write a Java class called **Chair** that has
a `double` variable called **size** and a `String` variable called **softness**.

### Chair Class:

Your `Chair` class must have the following items:

- Fields :
    - a `double` attribute named **size** which is not accessible from other classes
    - a `String` attribute named **softness** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a `double` and a `String` value to initialize the
      **size** and **softness** attributes.

- Methods:
    - a `setSize` method which accepts a `double` value, updates the **size** attribute with it, and is accessible from
      other classes
    - a `getSize` method which is accessible from other classes and returns the value of the **size** attribute
    - a `setSoftness` method which accepts a `String` value, updates the **softness** attribute with it, and is
      accessible from other classes
    - a `getSoftness` method which is accessible from other classes and returns the value of the **softness** attribute
    - a `toString` method which returns a String of the information about the `Chair` class of the form
      `"This Chair's size is x, and it's softness is y"` where x is the value of the size attribute, y is the value of
      the softness attribute.

### Test Class:

Your `Test` class will have a main method which initializes a `Chair` of **size** 10.2 and **softness** "Soft". Then it
should print the toString for this class.