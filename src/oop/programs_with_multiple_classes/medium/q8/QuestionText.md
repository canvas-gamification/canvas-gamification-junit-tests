# oop-programs_with_multiple_classes-medium-q8

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models objects within a house and different rooms. Make a Java program
consisting of a `Light` and a `Kitchen`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Light

Your `Light` class currently has the attributes `boolean isOn` and `String type`. Create a
constructor which is accessible from another class and initializes these fields in that order.


The `Light` class currently has the following items:

- Attributes:
    - A `boolean` called **isOn**
    - A `String` called **type**

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `boolean` and a `String` in 
that order as parameters and initializes the **isOn** and **type** fields with 
the input values.

## Kitchen

Your `Kitchen` class currently has a constructor, but is missing the fields the 
constructor sets. Based on the
constructor, add the **size**, **personCapacity**, and **lights** fields of the appropriate 
type to the table class.



The `Kitchen` class currently has the following items:

- Constructors:
    - A constructor which is visible from another class
      and initialize the **size** and **personCapacity** fields.
    - It should initialize **lights** to null.
You must add the following items to complete the class:
- Attributes:
    - based on the constructor write the **size** and **personCapacity**
  fields with the appropriate types.
    - Make it that is the constructor gets a negative value for size, it
  initializes it as 0.
    - An array of `Light` called **lights**