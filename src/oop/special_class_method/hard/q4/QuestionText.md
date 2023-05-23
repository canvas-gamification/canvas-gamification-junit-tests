# oop-special_class_method-hard-q4

## Question Text

Chemistry tells us a lot about the properties of different liquids. Write a Java class called **Detergent** that has a
`String` variable called **name** and another `String` variable called **strength**.

### Detergent Class:

Your `Detergent` class must have the following items:

- Fields :
    - a `String` field named **name** which is not accessible from other classes
    - a `String` field named **strength** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts two `String` values to initialize the
      **name** and **strength** fields.

- Methods:
    - a `setName` method which is accessible from other classes, accepts a `String` value, and updates the **name** field with it
    - a `getName` method which is accessible from other classes and returns the value of the **name** field
    - a `setStrength` method which is accessible from other classes, accepts a `String` value, and updates the **strength** field with it
    - a `getStrength` method which is accessible from other classes and returns the value of the **strength** field
    - a `toString` method which returns a String of the information about the `Detergent` class of the form
      `"The Detergent instance name is " + name + " and its strength is " + strength + "."`.

### Test Class:

Your `Test` class will have a main method which initializes a `Detergent` with the **name** "Bleach" and of **strength** "High". Then,
print the toString for this class.