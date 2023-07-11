# oop-special_class_method-hard-q4

## Question Text

Chemistry tells us a lot about the properties of different liquids. Write a Java class called **Detergent** that has a
`String` variable called **name** and another `String` variable called **strength**.

### Detergent Class:

Your `Detergent` class must have the following items:

- Attributes:
    - a `String` attribute named **name** which is not accessible from other classes
    - a `String` attribute named **strength** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts two `String` values to initialize the
      **name** and **strength** attributes.

- Methods:
    - a `setName` method which is accessible from other classes, accepts a `String` value, and updates the **name**
      attribute with it
    - a `getName` method which is accessible from other classes and returns the value of the **name** attribute
    - a `setStrength` method which is accessible from other classes, accepts a `String` value, and updates the
      **strength** attribute with it
    - a `getStrength` method which is accessible from other classes and returns the value of the **strength** attribute
    - a `toString` method which returns a String of the information about the `Detergent` class of the form
      `"The Detergent instance name is  x and its strength is y."` where x is the value of the **name**
      attribute and y is the value of the **strength** attribute.

### Test Class:

Your `Test` class will have a main method which initializes a `Detergent` with the **name** "Bleach" and of
**strength** "High". Then,
print the toString for this class.