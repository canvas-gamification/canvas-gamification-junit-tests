# oop-programs_with_multiple_classes-medium-q1

**Parsons**

- You want to write a program that models writing tools and stationery objects. Make a Java program with the following requirements:


## Pencil

Your `Pencil` class should have the following items:

- Attributes:
    - An `int` called **hardness**
    - A `boolean` called **isForSchool**

- Constructors:
    - A `public Pencil(int, boolean)` constructor to set the
      **hardness** and **isForSchool** attributes in that order

## Eraser

Your ``Eraser`` class should have the following items:

- Attributes:
    - An `double` called **size**

- Constructors:
    - A `public Eraser(double)` constructor to set the
    - **size** field

## TestPencilCase

- Your `TestPencilCase` class will have a `main` method which initializes two Pencil and a two Eraser, and prints out the
  attributes of each object, for that use the values in sample output. Use the `toString` method provided in each class 
  to do this.
- The sample output is as follows:
  ```
  Pencil 1: Pencil{hardness = 2, isForSchool = false}
  Pencil 2: Pencil{hardness = 1, isForSchool = true}
  Eraser 1: Eraser{size = 10.5}
  Eraser 2: Eraser{size = 4.3}
  ```