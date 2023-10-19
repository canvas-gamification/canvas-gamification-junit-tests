# oop-special_class_method-hard-q7

### Question Text:

You are writing a Java program that mimics different financial institutions or personal banks. Write a Java class called
`PiggyBank` that has the following description:

### PiggyBak Class:

Your `PiggyBank` class must have the following items:

- Attributes:
    - A `double` attribute named **money** which is not accessible from other classes
    - An `int` attribute named **time** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a`double` and a `int` to initialize the
      **money** and **time** attributes.
    - A constructor which is accessible from other classes without any input to initialize the
      **money** and **time** attributes to zero.

- Methods:
    - a `setMoney` method which accepts a `double` value, updates the **money** attribute with it, and is accessible
      from other classes
    - a `getMoney` method which is accessible from other classes and returns the value of the **money** attribute
    - a `setTime` method which accepts an `int` value, updates the **time** attribute with it, and is accessible
      from other classes
    - a `getTime` method which is accessible from other classes and returns the value of the **time** attribute
    - a `toString` method which returns a String of the information about the `PiggyBank` class of the form
      `"I have x dollars in me after y days."` where x is the value of the **money** attribute
      and y is the value of the **time** attribute

### Test Class:

Your `Test` class will have a main method which initializes a `PiggyBank` of **money** 125.5 and **time** 30. Then,
print the toString for this class.