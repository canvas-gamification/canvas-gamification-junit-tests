# oop-special_class_method-hard-q6

## Question Text

You are writing a Java program that mimics different Vehicles and their attributes. Write a Java class called **Car**
that has a `double` variable called **topSpeed** and another `String` variable called **type**. For this
class, write a constructor that accepts no parameters, but sets the variables **topSpeed** and **type** to 180 and null,
respectively. Also, write a constructor that accepts a `double` and a `String` value, and sets the values
of the **topSpeed** and **type** variable to those values, respectively. Also, write a **toString** method that returns
a summary of the attributes of the object. Also, write accessor and mutator methods for the necessary variables.

### Car Class:

Your `Car` class must have the following items:

- Fields :
    - a `double` field named **topSpeed** which is not accessible from other classes
    - a `String` field named **type** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a`double` and a `String` to initialize the
      **topSpeed** and **type** fields.

- Methods:
    - a `setTopSpeed` method which accepts a `double` value, updates the **topSpeed** field with it, and is accessible
      from
      other classes
    - a `getTopSpeed` method which is accessible from other classes and returns the value of the **topSpeed** field
    - a `setType` method which accepts a `String` value, updates the **type** field with it, and is accessible
      from other classes
    - a `getType` method which is accessible from other classes and returns the value of the **type** field
    - a `toString` method which returns a String of the information about the `Car` class of the form
      `"Car{topSpeed: " + topSpeed + ", type: " + type + "}"`.

### Test Class:

Your `Test` class will have a main method which initializes a `Car` of **topSpeed** 220 and **type** "Ford". Then,
print the toString for this class.