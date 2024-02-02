# oop-static_modifier-hard-q2

- Question Type: Java question

## Question Text

A factory typically has employees who control machines that build the same items all day long. Write a Java class called
`Lightbulb`.

## Lightbulb Class

Your `Lightbulb` class must have the following requirements:

- Attributes:
    - Note that all attributes should not be visible from another class
    - A _static_ `int` called **voltage**. This represents the voltage of the all `Lightbulb` objects,
      and should be set initially to 100 without having to call the constructor.
    - A `String` called **type**

- Constructors:
    - A constructor that is accessible from other methods, and accepts a `String` as a parameter to set the **type**
      attribute of the object.

- Methods:
    - Note that all methods in this class should be visible from another class
    - A mutator called `setVoltage` that gets an `int` value and change the voltage of all instances to the input value.
      It must not return anythin.
    - A `toString` method which returns the `String` "This lightbulb is a x light with y voltage.", where x is the value
      of the **type** attribute of the `Lightbulb` object and y is the value of the **voltage** attribute.

## Test Class

Your `Test` class must have the following items:

- Main method:
    - A `main` method which initializes three `Lightbulb` objects. The first one should be a `"LED"`, the second one
      should be a `"LCD"`, and the third one should be a `"Halogen"` lightbulb. These are the value of **type**
      attribute.
    - First set the voltage to 150 and print the first lightbulb, Then again change the voltage of the first lightbulb
      to 200 but print the second lightbulb, then again change the voltage of first lightbulb to 300 but this tim print
      the third light bulb. Note that you should print the lightbulbs using `toString` method and each in a separate
      line.