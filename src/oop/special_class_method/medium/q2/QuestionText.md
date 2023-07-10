# oop-special_class_method-medium-q2

## Question Text

You are about to start writing a program that involves luminous objects. Make a Java class called `Lamp` that has two
attributes called **brightness** and **isOn**. The class also has two constructors, one with 2 parameters to initialize
two attributes and one with 1 parameter that sets the second attribute to the default value.

### Question Type:

- Java question

### Lamp Class:

You are already given the following items:

- Attributes:
    - a `double` called **brightness** that is not accessible from other classes.
    - a `boolean` called **isOn** that is not accessible from other classes.

- Constructor:
    - a `Lamp` constructor that is visible to other classes and accepts a `double` and uses it to initialize the
      **brightness** attribute and initializes the **isOn** attribute to true.

You need to add the following items to the class:

- Constructor:
    - a `Lamp` constructor that is visible to other classes and accepts a `double` and a `boolean` and uses it to
      initialize the **brightness** and **isOn** attributes.

- Methods:
    - a `setBrightness` method which accepts a `double` and uses it to set the value of the **brightness** attribute
    - a `getBrightness` method which returns the value stored in the **brightness** attribute
    - a `setIsOn` method which accepts a `boolean` and uses it to set the value of the **isOn** attribute
    - a `getIsOn` method which returns the value stored in the **isOn** attribute
    - a `toString` method which returns the string `"My brightness is x and isOn is y"`, where x is the **
      brightness** attribute and y is the **isOn** attribute.
    - All of these methods must be acessible from other classes.
  