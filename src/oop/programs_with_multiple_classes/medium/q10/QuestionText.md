# oop-programs_with_multiple_classes-medium-q3

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models objects within a house and different rooms. Make a Java program
consisting of a `Vegetable` and a `Cupboard`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.


## Vegetable

The `Vegetable` class currently has the following items:

- Attributes:
    - A `boolean` called **isSpoiled**
    - A `double` called **weight**
    - A `String` called **countryOfOrigin**

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts a `boolean`, a `double` and a `String` in that order as parameters
      and initializes the **isSpoiled**, **weight**, and **countryOfOrigin** fields with the input values.
- Methods:
    -  Write a method called **eating** that
       decreases the value of **weight** by 0.5, and is accessible from other classes

## Cupboard

The `Cupboard` class currently has the following items:

- Constructors:
    - A constructor which is visible from another class
      and initialize the **size** and **colour** field and **vegetables** to null.

You must add the following items to complete the class:

- Attributes:
    - The **size** and **colour** with appropriate types based on the constructor.
    - An array of `Vegetable` objects called **vegetables**