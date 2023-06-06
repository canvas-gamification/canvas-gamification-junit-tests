# oop-programs_with_multiple_classes-medium-q7

## Question Information:

- Question Type: Java

## Question Text:

You want to write a program that models kitchen utensils and kitchen tools. Make a Java program
consisting of a `Knife` and a `Cabinet`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Knife

Your `Knife` class currently has the attributes `int size` and `String materialType`. Create a
constructor which is accessible from another class and initializes these fields in that order.

The `Knife` class currently has the following items:

- Attributes:
    - An `int` called **size** that is not accessible from another class.
    - A `String` called **materialType** that is not accessible from another class.

You must add the following items to complete the class:

- Constructors:
    - A constructor which is visible from another class and accepts an `int` and a `String` in that order as parameters
      and initializes the **size** and **materialType** attributes with the input values.

## Cabinet

Your `Cabinet` class currently has a constructor, but is missing the attributes the constructor sets. Based on the
constructor, add the **capacity** and **isFull** attributes of the appropriate type to the table class.

The `Cabinet` class currently has the following items:

- Constructors:
    - A constructor which is visible from another and initialize the **capacity** and **isFull** attributes.
    - It should initialize the **knifes** array to a array of **Knife** classes size of **capacity** with null instances
      of the **knife** class.

You must add the following items to complete the class:

- Attributes:
    - Write the **capacity** and **isFull** with appropriate types and make not be accessible from other classes.
    - Write a **knifes** attributes that is an array of **Knife** classes and is not accessible from other classes.
