# oop-user_defined_classes-hard-q2

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name

## Question Text

Dishwashers are convenient, but it can be easy to lose track of how much clean cutlery you have. Write a Java class 
called `DishWasher` to track the contents of the dishwasher. See the description below for the requirements.

### DishWasher Class:

Your `DishWasher` class should have the following items:

- Attributes:
    - An `int` called **forks** which is not visible from other classes
    - An `int` called **knives** which is not visible from other classes

- Constructors:
    - A constructor which accepts two ints and sets the **forks** and **knives** attributes. The first int should
      set **forks** attribute and the second the **knives** attribute.

- Methods:
    - A method called `loadDishWasher` which another class can give the number of dirty forks and dirty knives to be
      subtracted from the total number of **forks** and **knives**. The first int should set **forks** attribute and the
      second the **knives** attribute. Then the method should print "**forks** forks are still clean" and "**knives** 
      knives are still clean" to the console on separate lines.
  