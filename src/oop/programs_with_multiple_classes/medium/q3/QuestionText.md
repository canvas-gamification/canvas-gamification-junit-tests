# oop-programs_with_multiple_classes-medium-q3

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models writing tools and stationery objects.
It consists of a `Pencil` and a `Eraser`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.


## Pencil

The `Pencil` class currently has the following items:

- Attributes:
  - An `int` called **hardness**
  - A `boolean` called **isForSchool**

You must add the following items to complete the class:

- Constructors:
  - A constructor which is visible from another class and accepts an `int` and a `boolean` in that order as parameters
    and initializes the **hardness** and **isForSchool** fields with the input values.

## Eraser

The `Eraser` class currently has the following items:

- Constructors:
  - A constructor which is visible from another class and accepts a `double`
  and initialize the **size** field.
You must add the following items to complete the class:
- Attributes:
  - A `double` called **size**
- Methods:
  - A method called **erase** the decreases the size field by 1.