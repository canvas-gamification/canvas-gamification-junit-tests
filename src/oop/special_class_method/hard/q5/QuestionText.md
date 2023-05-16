# oop-special_class_method-hard-q5

## Question Text

You are writing a Java program that describes different types of roads and their attributes. Write a Java class called
**Road** that has an `int` variable called **lanes**, a `String` variable called **typeOfRoad**, and an
`int` variable called **maxCapacity**. For this class, write a constructor that accepts two `int` values
and a String value, and sets the value of the class variables to those input values. Also, write a **toString** method
that summarizes the attributes of the object. Also, write accessor and mutator methods for the necessary variables.

### Road Class:

Your `Road` class must have the following items:

- Fields :
    - a `int` attribute named **lanes** which is not accessible from other classes
    - a `String` attribute named **typeOfRoad** which is not accessible from other classes
    - a `int` attribute named **maxCapacity** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts an `int`, a `String`, and
      another `int` value to initialize the **lanes**, **typeOfRoad**, and **maxCapacity** attributes.

- Methods:
    - a `setLanes` method which accepts a `int` value, updates the **lanes** field with it, and is accessible from
      other classes
    - a `getLanes` method which is accessible from other classes and returns the value of the **lanes** field
    - a `setTypeOfRoad` method which accepts a `String` value, updates the **typeOfRoad** field with it, and is
      accessible
      from other classes
    - a `getTypeOfRoad` method which is accessible from other classes and returns the value of the **typeOfRoad** field
    - a `setMaxCapacity` method which accepts a `int` value, updates the **maxCapacity** field with it, and is
      accessible from
      other classes
    - a `getMaxCapacity` method which is accessible from other classes and returns the value of the **maxCapacity**
      field
    - a `toString` method which returns a String of the information about the `Road` class of the form
      `"Road{lanes: " + lanes + ", typeOfRoad: " + typeOfRoad + ", maxCapacity: " + maxCapacity + "}"`.

### Test Class:

Your `Test` class will have a main method which initializes a `Road` of **lanes** 3 and **typeOfRoad** "Highway",
and **maxCapacity** 100. Then, print the toString for this class.