# oop-programs_with_multiple_classes-medium-q1

You want to make a program that models a room with a chair and a table. To do this, you will create a Java program that
consists of a `Chair`, `Table`, and `TestRoom` class. See the requirements below for each class. Note that
the `toString` methods of the `Chair` and `Table` class are provided.

## Chair

Your `Chair` class should have the following items:

- Attributes:
    - A `String` called **comfort**
    - An `int` called **weightCapacity**
    - An `int` called **longevity**
- Constructors:
    - A `public Chair(String, int, int)` constructor to set the **comfort**, **weightCapacity**, and **longevity** of
      the chair in that order

## Table

Your ``Table`` class should have the following items:

- Attributes:
    - A `String` called **woodType**
    - An `int` called **numSeats**

- Constructors:
    - A `public Table(String, int)` constructor to set the **woodType** and **numSeats** field

## TestRoom

- Your `TestRoom` class will have a `main` method which initializes two chairs and a table, and prints out the
  attributes of each object. Use the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Chair 1: Chair{comfort='couchy', weightCapacity=350, longevity=5}
  Chair 2: Chair{comfort='back support', weightCapacity=250, longevity=10}
  Table: Table{woodType='cherry', numSeats=8}
  ```
