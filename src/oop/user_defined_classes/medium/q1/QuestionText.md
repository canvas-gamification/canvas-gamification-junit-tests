# oop-user_defined_classes-medium-q1

## Question Information:

- Question Type: Parsons with distractors
- Distractors:
    - private class Circle
    - public int position;
    - public String colour;
    - public void Circle()
    - public Circle()
    - return position;
    - int position = -1;
    - String colour = "";
    - position = gen.nextInt();

## Question Text:

You want to write a program that models certain objects and where they are located. Make a Java class called `Circle`
with the specifications described bellow to accomplish this.

### Circle Class

Your `Circle` class should have the following items:

- Attributes:
    - An `int` called **position**
    - A `String` called **colour**

- Constructors:
    - A constructor which accepts an `int` and a `String` in that order and initializes **position** and **colour**
      with the input values.

- Methods:
    - A method called `moveLocation` which another class can access to randomly set the value of **position** to be a
      number from 0 (inclusive) to 100 (exclusive) and returns nothing.
