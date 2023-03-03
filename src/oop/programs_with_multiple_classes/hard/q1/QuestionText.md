# oop-programs_with_multiple_classes-hard-q1

You want to write a program that models a group of people in a circus. To do this, create a Java program with three
classes: `Circus`, `Member`, and `TestGroup`. See the requirements below for each class. Note that a `toString` method
has been provided in the `Member` and `Circus` classes for you to use.

## Circus Class

Your `Circus` class should have the following items:

- Attributes:
    - An `int` called **numMembers**
- Constructors:
    - A `public Circus(int)` constructor which initializes the **numMembers** field with the passed integer

## Member Class

Your `Member` class should have the following items:

- Attributes:
    - A `String` called **title**
- Constructors:
    - A `public Member(String)` constructor which initializes the *title* field with the passed String

## TestGroup Class

- Your `TestGroup` class will have a `main` method which initializes a `Circus` and two `Member` objects, and prints out
  the attributes of each object. Initialize the objects with the values shown in the sample output and print them out.
  Use the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Circus: Circus{numMembers=100} 
  Member 1: Member{title='Juggler'} 
  Member 2: Member{title='Tightrope Walker'}
  ```
