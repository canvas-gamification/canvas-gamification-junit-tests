# oop-programs_with_multiple_classes-hard-q2

You want to write a program that models a group of people and their blanket fort. To do this, create a Java program with
three classes: `Person`, `Blanket`, and `TestFort`. See the requirements below for each class. Note that a `toString`
method has been provided in the `Person` and `Blanket` classes for you to use.

## Person Class

Your `Person` class should have the following items:

- Attributes:
    - A `double` called **height**
- Constructors:
    - A constructor which accepts a double to initialize the **height** field and is accessible from other classes

## Blanket Class

Your `Blanket` class should have the following items:

- Attributes:
    - A `String` called **size**
    - An `int` called **threadCount**
- Constructors:
    - A constructor which accepts a String to initialize the **size** field and an int to initialize the **threadCount**
    - This constructor should be accessible from other classes

## TestFort Class

- Your `TestFort` class will have a `main` method which initializes two `Person` and one `Blanket` objects, and prints
  out the attributes of each object. Initialize the objects with the values shown in the sample output and print them
  out. Use the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Person 1: Person{height=75.0}
  Person 2: Person{height=63.0}
  Fort: Blanket{size='Large', threadCount=1500}
  ```

