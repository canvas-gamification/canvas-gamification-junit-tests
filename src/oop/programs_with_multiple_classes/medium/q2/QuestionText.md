# oop-programs_with_multiple_classes-medium-q1

**Parsons**

You want to write a program that models furniture within a home. Make a Java program with the following requirements:


## Bed

Your `Bed` class should have the following items:

- Attributes:
    - An `int` called **weightCapacity**
    - A `boolean` called **isComfy**

- Constructors:
    - A `public Bed(int, boolean)` constructor to set the 
  **weightCapacity** and **isComfy** the chair in that order

## Pillow

Your ``Pillow`` class should have the following items:

- Attributes:
    - A `String` called **filling**
    - An `int` called **yearMade**

- Constructors:
    - A `public Pillow(String, int)` constructor to set the 
    - **filling** and **yearMade** field

## TestRoom

- Your `TestRoom` class will have a `main` method which initializes two pillow and a bed, and prints out the
  attributes of each object. Use the values in the sample output to initialize these objects. To print out the information about the objects,
  use the `toString` method provided in each object.
- The sample output is as follows:
  ```
  Pillow 1: Pillow{filling = Cotton, yearMade = 2010}
  Pillow 2: Pillow{filling = Air, yearMade = 1995}
  Bed: Bed{isComfy = true, weightCapacity = 400}
  ```