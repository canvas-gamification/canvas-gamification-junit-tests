# oop-programs_with_interesting_classes-easy-q8

- Parsons Question

## Question Text

You are environmentally conscious, and you want to know how much water your daily activities consume. Make a class
called `Activity` to track your water usage using the requirements below. Then make a `TestWaterUsage` class to 
test `Activity`.

### Activity Class

The `Activity` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class.
    - A `String` attribute called **name**
    - A `double` attribute called **consumptionRate**
    - An `int` attribute called **duration**

- Constructors:
    - A constructor visible from another class that accepts a `String`, a `double`, and an `int` as parameters, and uses
      the values to initialize the **name**, **consumptionRate**, and **duration** attributes.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A method that returns the **name** attribute called `getName`.
    - A `usageCalculator` method which returns a double. The returned value should be **consumptionRate** multiplied by 
      **duration**.
    - Note that all methods should be visible from other classes.

### TestWaterUsage class

- Main method:
    - In the main method create 3 `Activity` classes and then print the sum of water consumption for all of them.
      Find the activity with the worst (highest) water consumption and then print it.