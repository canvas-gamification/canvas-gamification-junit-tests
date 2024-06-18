# oop-static_modifier-hard-q2

- Question Type: Java question

## Question Text

There are many different kinds of light bulbs. A light bulb factory manufactures thousands of light bulbs at one voltage
which changes every day and must keep track of its production and inventory. Write a Java class called `Lightbulb` to
model this using the requirements below.

## Lightbulb Class

Your `Lightbulb` class must have the following requirements:

- Attributes:
    - None of the attributes should be visible from another class.
    - A _static_ `int` called **voltage**. This represents the voltage of all `Lightbulb` objects,
      and should initially be set to 100 before calling the constructor.
    - A `String` called **type**.

- Constructors:
    - A constructor that is accessible from other methods, and accepts a `String` as a parameter to set the **type**
      attribute of the object.

- Methods:
    - Note that all methods in this class should be visible from another class.
    - A mutator called `setVoltage` that has an `int` parameter and changes the voltage of all instances to the input
      value. It must not return anything.
    - A `toString` method which returns the `String` "This lightbulb is a x light with y voltage.", where x is the value
      of the **type** attribute of the `Lightbulb` object and y is the value of the **voltage** attribute.

## Test Class

Your `Test` class must have the following items:

- Main method:
    - A `main` method which initializes three `Lightbulb` objects. The first one should be a `"LED"`, the second one
      should be a `"LCD"`, and the third one should be a `"Halogen"` lightbulb. These are the value of **type**
      attribute.
    - First, set the voltage to 150 and print the first lightbulb. Then change the voltage to 200 and print the second 
      lightbulb, then change the voltage to 300 and print the third light bulb. Note that you should print the 
      lightbulbs using the toString method each on a separate line.