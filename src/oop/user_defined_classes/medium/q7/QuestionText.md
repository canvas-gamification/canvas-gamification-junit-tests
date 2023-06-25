# oop-user_defined_classes-medium-q7

## Java

Civil engineers design roads and recommend reasonable speed limits to ensure everyone's
safety. Make a Java class called `Highway` that has two attributes called **speedLimit** and
**fine** whose values are initialized by the constructor. This class has a method called
**issueTicket** that takes as input a driving speed and returns a fine if it is more
than the speedLimit.

## Highway

The `Highway` class you are given has the following items:

- Attributes:
    - An `int` called **speedLimit** that is not accessible from other classes.
    - An `int` called **fine** that is not accessible from other classes.
- Constructor:
    - A constructor to initialize the **speedLimit** and initialize **fine** to 250. It is
      accessible from other classes.

You need to add the following items:

- Methods:
    - Create the method **issueTicket** that takes an int which is the current speed and
      return an `int` that is the fine needed to be paid for the input speed.
    - This method should check to see if the current speed is more that **speedLimit**, and
      if it is it should return the value of **fine** otherwise it should return 0.