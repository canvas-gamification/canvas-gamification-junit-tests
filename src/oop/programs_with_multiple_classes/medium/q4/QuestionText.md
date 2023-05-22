# oop-programs_with_multiple_classes-medium-q4

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models vehicular components within different types of vehicles. Make a Java program
consisting of
a `Wheel` and a `Chassis`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Wheel

The `Wheel` class currently has the following items:

- Attributes:
    - An `double` called **durability**
    - A `String` called **manufacturer**

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `double` and a `String` in that order as
      parameters
      and initializes the **durability** and **manufacturer** attributes with the input values.
    - The constructor should check that the **durability** attribute is non-negative, if not initialize it 0.

## Chassis

The `Chassis` class currently has the following items:

- Constructors:
    - A constructor which is visible from another class
      and initialize the **materialType** and **wheels** attributes.
    -

You must add the following items to complete the class:

- Attributes:
    - The  **materialType** attribute according to the given constructor.
    - tThe **wheels** attribute that is a array of **Wheel** instances.