# oop-special_class_method-hard-q7

## Question Text

You are writing a Java program that mimics different financial institutions or personal banks. Write a Java class called
**PiggyBank** that has a `double` variable called **money** and another `int` variable called **time**. 
For this class, write a constructor that accepts no parameters, but sets the variables **money** and **time** to 0 and 0, 
respectively. Also, write a constructor that accepts a `double` and an `int` value, and sets the values of 
the **money** and **time** variable to those values, respectively. Also, write a **toString** method that returns a 
summary of the attributes of the object. Also, write accessor and mutator methods for the necessary variables.


### PiggyBak Class:

Your `PiggyBank` class must have the following items:

- Fields :
    - A `double` attribute named **money** which is not accessible from other classes
    - An `int` attribute named **time** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a`double` and a `String` to initialize the
      **topSpeed** and **type** attributes.

- Methods:
    - a `setMoney` method which accepts a `double` value, updates the **money** attribute with it, and is accessible
      from other classes
    - a `getMoney` method which is accessible from other classes and returns the value of the **money** attribute
    - a `setTime` method which accepts an `int` value, updates the **time** attribute with it, and is accessible
      from other classes
    - a `getTime` method which is accessible from other classes and returns the value of the **time** attribute
    - a `toString` method which returns a String of the information about the `PiggyBank` class of the form
      `"I have " + money + " dollars in me after " + time + " days."`.

### Test Class:

Your `Test` class will have a main method which initializes a `PiggyBank` of **money** 125.5 and **time** 30. Then,
print the toString for this class.