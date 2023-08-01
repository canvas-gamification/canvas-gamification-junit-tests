# oop-programs_with_multiple_classes-medium-q5

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models technology and work surfaces. Make a Java program consisting of a `Monitor`
and a `Desk`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Monitor

The `Monitor` class currently has the following items:

- Attributes:
    - An `int` called **size** that is not accessible from other classes.
    - A `boolean` called **isOn** that is not accessible from other classes.

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `int` and a `boolean` as parameters
      and initializes the **size** and **isOn** fields with the input value.

- Methods:
    - A method called **change** that changes the value of **isOn** that is accessible from other classes and
      does not return anything;

## Desk

The `Desk` class currently has the following items:

- Attributes:
    - A `String` called **materialType** that is not accessible from other classes.
    - An array of `Monitor` objects called **monitors** that is not accessible from other classes.

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another classes and accepts a `String`
      and initialize the **materialType** attribute and initializes the **monitors**
      fields to an array of size 2.
