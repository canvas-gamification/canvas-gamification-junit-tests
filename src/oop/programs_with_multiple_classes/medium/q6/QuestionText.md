# oop-programs_with_multiple_classes-medium-q6

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models food and different storage containers. Make a Java program consisting of
a `Meat` class and a `Fridge` class. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Meat

The `Meat` class currently has the following items:

- Attributes:
    - A `boolean` called **isSpoiled** that is not accessible from other classes.
- Constructors:
    - A constructor which is visible from another class and accepts a `boolean` as parameter
      and initializes the **isSpoiled** field with the input value that is accessible from other classes.

You must add the following items to complete the class:

- Methods:
    - A **timePassed** method that change the value of **isSpoiled** to true and is accessible from another classes
      and does not return anything.

## Fridge

The `Fridge` class currently has the following items:

- Attributes:
    - A `int` called **size** that is not accessible from other classes.
    - An array of `Meat` objects called **meats** that is not accessible from other classes.

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts a `int`
      and initialize the **size** attribute.
    - If the value of the input for size is negative it should initialize it as 0.
    - Initializes the value of **meats** to an array of **Meat** objects with the size of **size** (make sure
      you initialize the **size** field first).
