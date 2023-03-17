# oop-special_class_method-hard-q1

## Question Text

You are working on a software animation for an object that grows and pops. Write a Java class called `Bubble`
that models this, and implement a `Test` class to demonstrate it. See the requirements below for each class.

### Bubble Class:

Your `Bubble` class must have the following items:

- Fields :
    - a `double` field named **size** which is not accessible from other classes
    - a `boolean` field named **isPopped** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a double value to initialize the **size** field
      and sets the **isPopped** boolean to false

- Methods:
    - a `setSize` method which accepts a `double` value, updates the **size** field with it, and is accessible from
      other classes
    - a `getSize` method which is accessible from other classes and returns the value of the **size** field
    - a `setIsPopped` method which accepts a `boolean` value, updates the **isPopped** field with it, and is accessible
      from other classes
    - a `getIsPopped` method which is accessible from other classes and returns the value of the **isPopped** field
    - a `toString` method which returns a String of the information about the `Circle` class of the form "size: x,
      isPopped: y" where x is the value of the **size** field and y is the value of the **isPopped** field

### Test Class:

Your `Test` class will have a main method which initializes a `Bubble` of size 5, sets the size to the current size
times two, sets **isPopped** to true, and prints the `toString` of the updated `Bubble`.
