# oop-programs_with_multiple_classes-medium-q3

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models objects within a house and different rooms. Make a Java program
consisting of a `Monitor` and a `Desk`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Monitor

The `Monitor` class currently has the following items:

- Attributes:
    - An `int` called **countSize** that is not accessible from other classes.
    - A `String` called **typeScreen** that is not accessible from other classes.
    - A `boolean` called **isRenewed** that is not accessible from other classes

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `int`, a `String`, and a `boolean`
      in that order as parameters and initializes the **countSize**,  **typeScreen**,
      and **isRenewed** attributes with the input values.

- Methods
    - Write a method called **recycled** that sets the value of **isRenewed** to true, and is accessible from other
      classes.

## Desk

The `Desk` class currently has the following items:

- Constructors:
    - A constructor that initializes the **materialType** and **yearsOld** attributes, and initializes the
      **monitors** attribute to an array of 3 null instances of **Monitor** class.
    - It is not accessible from other classes.

You must add the following items to complete the class:

- Attributes:
    - Based on the constructor write the **materialType** and **yearsOld** attributes with
      the appropriate types that are not accessible from other classes.
    - An array of `Monitor` objects called **monitors** that is not accessible from other classes.
  