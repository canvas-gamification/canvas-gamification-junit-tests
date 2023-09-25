# oop-special_class_method-hard-q5

### Question Text

You are writing a Java program that describes different types of roads and their attributes. Write a Java class called
Road the has the following description:

### Road Class:

Your `Road` class must have the following items:

- Attributes:
    - a `int` attribute named **lanes** which is not accessible from other classes
    - a `String` attribute named **typeOfRoad** which is not accessible from other classes
    - a `int` attribute named **maxCapacity** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts an `int`, a `String`, and
      another `int` value to initialize the **lanes**, **typeOfRoad**, and **maxCapacity** attributes.

- Methods:
    - a `setLanes` method which accepts a `int` value, updates the **lanes** attribute with it, and is accessible from
      other classes
    - a `getLanes` method which is accessible from other classes and returns the value of the **lanes** attribute
    - a `setTypeOfRoad` method which accepts a `String` value, updates the **typeOfRoad** attribute with it, and is
      accessible from other classes
    - a `getTypeOfRoad` method which is accessible from other classes and returns the value of the **typeOfRoad**
      attribute
    - a `setMaxCapacity` method which accepts a `int` value, updates the **maxCapacity** attribute with it, and is
      accessible from other classes
    - a `getMaxCapacity` method which is accessible from other classes and returns the value of the **maxCapacity**
      attribute
    - Note that all setter methods return type must be void
    - a `toString` method which returns a String of the information about the `Road` class of the form
      `"The Road instance lanes is " + lanes + ", its typeOfRoad is " + typeOfRoad + ", and its maxCapacity is " + maxCapacity + "."`
      .

### Test Class:

Your `Test` class will have a main method which initializes a `Road` of **lanes** 3, **typeOfRoad** "Highway",
and **maxCapacity** 100. Then, print the toString for this class.