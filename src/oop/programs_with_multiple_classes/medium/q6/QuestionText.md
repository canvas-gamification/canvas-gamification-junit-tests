# oop-programs_with_multiple_classes-medium-q6

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models food and different storage containers. Make a Java program consisting of
a `Vegtable` and a `Cupboard`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Vegetable

The `Vegetable` class currently has the following items:

- Attributes:
    - A `boolean` called **isSpoiled**
- Constructors:
    - A constructor which is visible from another class and accepts a `boolean` as parameter
      and initializes the **isSpoiled** field with the input value.

You must add the following items to complete the class:

- Methods:
    - A **timePassed** method that change the value of **countSize** to true and is accessible from another class.
      field.

## Cupboard

Your `Cupboard` class currently has the attributes `int size` and `Vegetable[] vegetables`. Create a
constructor which is accessible from another class and initializes this field.

The `Cupboard` class currently has the following items:

- Attributes:
    - A `int` called **size**
    - An array of `Vegetable` objects called **vegetables**.

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts a `int`
      and initialize the **size** field.
    - If the value of size is negative it should initialize it as 0.
    - Initializes the value of **vegtables** to null.