# oop-programs_with_multiple_classes-medium-q4

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models vehicular components within different types of vehicles. Make a Java program
consisting of a `Wheel` and a `Chassis`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Wheel

The `Wheel` class currently has the following items:

- Attributes:
    - An `double` called **durability** that is not visible from other classes
    - A `String` called **manufacturer** that is not visible from other classes

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts a `double` and a `String` in that order as
      parameters and initializes the **durability** and **manufacturer** attributes with the input values.
    - The constructor should check that the **durability** attribute is non-negative, and if not initialize it to zero.

## Chassis

The `Chassis` class currently has the following items:

- Constructors:
    - A constructor visible from another class and initializes the **materialType** and **wheels** attributes.
    - It should initialize the **wheels** attribute as an array of 4 null *Wheel** classes.

You must add the following items to complete the class:

- Attributes:
    - The  **materialType** attribute of type `String`, which is not visible from another class.
    - The **wheels** attribute, which is not visible from another class, that is an array of four **Wheel** instances.
