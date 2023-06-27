# oop-object_independence-medium-q2

## Question Info

- Question type: Parsons

## Question Text

You've noticed that there are line-ups everywhere. So, you decided to write a program that predicts how long you need to
wait in them. Make a program called  **PhoneWaitList** that has an attribute called **numAhead**, with a basic accessor
and mutator method and a **toString()** method.

### PhoneWaitList Class

Your `PhoneWaitList` class must have the following items:

- Attributes:
    - An `int` called **numAhead**
    - Note that neither of these attributes should be visible from another class

- Constructors:
    - A single constructor with a parameter `int` that initalzies the **numAhead** attribute
    - This constructor should be visible from another class

- Methods:
    - a `getNumAhead` method which is accessible from other classes and returns the value of the **numAhead** attribute
    - a `setNumAhead` method which accepts an `int` value, updates the **numAhead** attribute with it, and
      is accessible from other classes
    - a `toString` method which returns a String of the information about the `PhoneWaitList` class of the form
      `There are " + numAhead + " people ahead of you`, and is visible from other classes.

### TestWaitList Class

Your `TestWaitList` class must have the following items:

- Methods:
    - A `main` method which initializes two PhoneWaitList objects, one with a **numAhead** of 5 and
      the other with a **numAhead** of 2, and prints them using the **toString** method.
