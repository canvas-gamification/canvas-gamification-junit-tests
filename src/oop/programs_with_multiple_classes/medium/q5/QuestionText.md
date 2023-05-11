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
    - An `int` called **size**
    - A `boolean` called **isOn**

- Constructors:
    - A constructor which is visible from another class and accepts an `int` and a `boolean` as parameters
      and initializes the **size** and **isOn** fields with the input value.

You must add the following items to complete the class:

- Methods:
    - A method called **change** that changes the truth value of **isOn**;

## Desk

The `Desk` class currently has the following items:

- Attributes:
    - A `String` called **materialType**
    - An array of `Monitor` objects called **monitors**  

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts a `String`
      and initialize the **materialType** field and initializes the **monitors**
  fields to null.