# oop-special_class_method-medium-q7

## Question Text

Financial literacy has been recognized as an important life skill for young people. Make a Java class called 
**PiggyBank** that has several attributes called  **numPennies** and **numNickels**. This class has the basic 
constructor that initializes the attributes, accessors and mutators for each attribute, and a **toString()** method that 
returns the total amount of money available as a String.

### PiggyBank Class:

Your `PiggyBank` class already has the following items:

- Attributes:
    - An `int` called **numPennies**
    - An `int` called **numNickels**
    - These attributes are not visible from other classes.

- Constructor:
    - a `PiggyBank` constructor that is visible to other classes and initialize the
      **numPennies** and **numNickels** attributes to zero.

You need to add the following items:

- Methods:
    - a `setNumPennies` method which accepts an `int` and uses it to set the value of the **numPennies** attribute
    - a `getNumPennies` method which returns the value stored in the **numPennies** attribute
    - a `setNumNickels` method which accepts an `int` and uses it to set the value of the **numNickels** attribute
    - a `getNumNickels` method which returns the value stored in the **numNickels** attribute
    - a `toString` method which returns the string `"The total amount is $" + dollars` where dollars the sum of
  money that we have in dollors.
    - All of these methods are visible from other classes.