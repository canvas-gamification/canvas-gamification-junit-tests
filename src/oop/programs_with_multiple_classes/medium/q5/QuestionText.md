# oop-programs_with_multiple_classes-medium-q5

**Parsons**

You want to write a program that models technology and work surfaces. Make a Java program with the following requirements:


## Monitor

Your `Monitor` class should have the following items:

- Attributes:
    - An `int` called **countSize**

- Constructors:
    - A `public Monitor(int)` constructor to set the
      **countSize** field
- Methodes:
    - A `public void fallen()` method that decreases the value of
      **countSize** by 1.

## Desk

Your ``Desk`` class should have the following items:

- Attributes:
    - A `String` called **materialType**

- Constructors:
    - A `public Desk(String)` constructor to set the
      **materialType** field

## TestWorkSetUp

- Your `TestWorkSetUp` class will have a `main` method which initializes two Monitor and a Desk and prints out the
  attributes of each object. Use the values in the sample output to initialize these objects. To print out the information about the objects,
  use the `toString` method provided in each object.
- The sample output is as follows:
  ```
    Monitor{countSize = 21}
    Monitor{countSize = 27}
    Bed{materialType = Milani}
  ```