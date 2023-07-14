# oop-programs_with_multiple_classes-medium-q1

You want to make a program that models a room with a chair and a table. To do this, you will create a Java program that
consists of a `Chair` and a `Table`. See the requirements below for each class. Note that parts of each class are
already provided, you only need to implement the other portions.

## Chair

THe `Chair` class currently has the following items:

- Fields:
    - A `String` called comfort
    - An `int` called weightCapacity
    - An `int` called longevity

You must add the following items to complete the class:

- Constructor:
    - A constructor which accepts the parameters `String, int, int`, where the first int is for the weight capacity
      field, and the second one is for the longevity field.
    - This constructor should be visible from another class
    - The constructor should check that both the passed integers are not negative. If the int to set the weight capacity
      is negative, set the field to `100`, and if the int for the longevity field is negative, set it to `12`.

## Table

The `Table` class currently has the following items:

- Constructor:
    - A `public Table(String, int)` constructor to set the **woodType** and **numSeats** fields

You must add the following items to complete the class:

- Fields:
    - A `String` called **woodType**
    - An `int` called **numSeats**
    - Both of these should not be visible from another class

- Methods
    - A method called `woodType` that prints the message `This table is made out of x` where x is the woodType field of
      the table.
    - This method should be visible from another class, and it should not have a return type
    