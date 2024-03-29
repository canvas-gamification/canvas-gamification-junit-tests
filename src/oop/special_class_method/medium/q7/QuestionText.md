# oop-special_class_method-medium-q7

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
    - a `toString` method which returns the string `"The total amount is $x"` where x is the sum of
  money that we have in dollars. To do this, calculate the total dollar amount based on the **numPennies** and **numNickels** attributes (one penny is $0.01 and one nickel is $0.05).
    - All of these methods are visible from other classes.
    - All of the `set` methods must not return anything.
