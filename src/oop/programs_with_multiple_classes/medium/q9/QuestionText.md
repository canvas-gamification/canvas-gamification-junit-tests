# oop-programs_with_multiple_classes-medium-q3

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models objects within a house and different rooms. Make a Java program
consisting of a `Monitor` and a `Desk`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.


## Monitor

Your `Monitor` class currently has the attributes `int countSize`, `String typeScreen`,
and `boolean isRenewed`. Create a constructor which is accessible from another class
and initializes these fields in that order. Also, write a method called **recycled** that
sets the value of **isRenewed** to true, and is accessible from other classes.

The `Monitor` class currently has the following items:

- Attributes:
    - An `int` called **countSize**
    - A `String` called **typeScreen**
    - A `boolean` called **isRenewed**

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `int`, a `String`, and a `boolean` 
  in that order as parameters and initializes the **countSize**,  **typeScreen**,
  and **isRenewed** fields with the input values.
- Methods
    - Write a method called **recycled** that
      sets the value of **isRenewed** to true, and is accessible from other classes.

## Desk

Your `Desk` class currently has a constructor, but is missing the fields the constructor sets. Based on the
constructor, add the **materialType** and **yearsOld** fields of the appropriate type to the table class.


The `Desk` class currently has the following items:

- Constructors:
    - A constructor that initializes the **materialType** and **yearsOld** fields.
You must add the following items to complete the class:
- Attributes:
    - Based on the constructor write the **materialType** and **yearsOld** fields with
  the appropriate types.
    - An array of `Monitor` objects called **monitors**

