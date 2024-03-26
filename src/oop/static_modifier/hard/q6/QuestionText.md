# oop-static_modifier-hard-q6

- Question Type: Java question

## Farm Class

Your `Farm` class must have the following requirements:

- Attributes:
    - A _static_ `double` called **foodInSilo**. This represents the total number of food available in the silo for 
    `Farm` objects, and should be set initially to 50 without having to call the constructor. Note that
      it should not be visible from other classes.
    - A `double` called **amountPerAnimal** which is the amount of the food needed for each animal. Note that it should
      not be visible from other classes.
    - An `int` called **numAnimals** which is the number of animals in the farm. Note that it should
      not be visible from other classes.

- Constructors:
    - A constructor that is accessible from other methods, and accepts a `double` and an `int` as parameters to set the
      **amountPerAnimal** and **numAnimals** attribute of the object.

- Methods:
    - Note that all methods in this class should be visible from another class
    - A `foodNeeded` method which returns a `double` equal to the value of **amountPerAnimal** times **numAnimals**
      which represents the total amount of food needed by the `Farm` object.
    - A `receiveDonation` method which prints "Thank you for your donation." if the total food needed is less than the
      amount available for donation, **foodDonation** value and subtract it from available food, and prints "Thank you,
      but there is not enough for everyone here." otherwise.

## TestDonation Class

Your `TestDontion` class must have the following items:

- Main method:
    - A `main` method which initializes 3 `Farm` objects with the following **amountPerAnimal** amounts in order:
      0.5, 0.2, 1 and following **numAnimals** numbers in order: 10, 20, 50. Then in a loop from first to third farm
      it should try to donate food by printing "Try to donate here... " and using **recieveDonation** method until there
      can not be any food donated. Then it should print "There is no more food left today.". All prints are in separate lines.
  