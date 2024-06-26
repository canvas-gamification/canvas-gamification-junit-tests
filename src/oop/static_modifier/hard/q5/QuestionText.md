# oop-static_modifier-hard-q5

- Question Type: Java question

## Question Text

Carpet squares are easy to order but the colour of different batches can be slightly different and so cannot be used for 
the same carpet. Write a Java class called `Carpet` to keep track of the carpet squares of the most recent order using the 
requirements below. Then write a class called `TestCoverage` to test `Carpet`.

## Carpet Class

Your `Carpet` class must have the following requirements:

- Attributes:
    - A _static_ `double` called **materialAreaAvailable**. This represents the total number of carpet squares available for
      making `Carpet` objects, and should be set initially to 300 without having to call the constructor.
    - A `double` called **houseArea** which is the area of the house needed to be floored.
    - Neither of these attributes should be visible from other classes.

- Constructors:
    - A constructor that is accessible from other methods, and accepts an `double` as a parameter to set the
      **houseArea** attribute of the object.

- Methods:
    - A `canCompleteFlooring` method which return false if the **houseArea** value is more than
      **materialAreaAvailable**, meaning that the flooring cannot be made, or subtract the **houseArea** value from
      the **materialAreaAvailable** and return true. Note that this method should be visible from another class.

## TestCoverage Class

Your `TestCoverage` class must have the following items:

- Main method:
    - A `main` method which initializes 5 `Carpet` objects with **houseArea** of each of them being in order: 126, 133,
      81, 100, 90.25, 156.25. Then go through them in the same order to floor them using the `canCompleteFlooring` method. 
      Finally, print how many of the houses can be floored in this format:
      "There is enough material for the first x houses" where x is the number of floorings made.