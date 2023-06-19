# oop-programs_with_multiple_classes-medium-q8

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models objects within a house and different rooms. Make a Java program
consisting of a `Light` and a `Kitchen`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Light

The `Light` class currently has the following items:

- Attributes:
    - A `boolean` called **isOn** that is not accessible from other classes.
    - A `String` called **type** that is not accessible from other classes.

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `boolean` and a `String` in
      that order as parameters and initializes the **isOn** and **type** attributes with
      the input values.

## Kitchen

The `Kitchen` class currently has the following items:

- Constructors:
    - A constructor which is visible from another class
      and initialize the **size** and **personCapacity** attributes.
    - It should initialize **lights** to an array of **Light** classes with the size of **size** attribute value.

You must add the following items to complete the class:

- Attributes:
    - based on the constructor write the **size** and **personCapacity** attributes with the appropriate types.
    - An array of `Light` called **lights**
- Constructors:
    - Change the constructor so that if it gets a negative value for **size** it should initialize it to zero.
    - They should not be accessible from other classes.