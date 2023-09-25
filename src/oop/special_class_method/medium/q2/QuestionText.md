# oop-special_class_method-medium-q2

## Question Text

You are about to start writing a program that involves luminous objects. Make a Java class called `Lamp` with the 
following description.

### Question Type:

- Java question

### Lamp Class:

You are already given the following items:

- Attributes:
    - a `double` called **brightness** that is not accessible from other classes.
    - a `boolean` called **isOn** that is not accessible from other classes.

- Constructor:
    - a `Lamp` constructor that is visible to other classes, accepts a `double` and uses it to initialize the
      **brightness** attribute, and initializes the **isOn** attribute to true.
    - - a `Lamp` constructor that is visible to other classes and accepts a `double` and a `boolean` and uses it to
        initialize the **brightness** and **isOn** attributes.

You need to add the following items to the class:

- Methods:
    - a `setBrightness` method which accepts a `double` and uses it to set the value of the **brightness** attribute
    - a `getBrightness` method which returns the value stored in the **brightness** attribute
    - a `setIsOn` method which accepts a `boolean` and uses it to set the value of the **isOn** attribute
    - a `getIsOn` method which returns the value stored in the **isOn** attribute
    - a `toString` method which returns the string `"My brightness is x and isOn is y"`, where x is the
      **brightness** attribute and y is the **isOn** attribute.
    - All of these methods must be acessible from other classes.
    - The setter method must not have any return value (It must be void).
  