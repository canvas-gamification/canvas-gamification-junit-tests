# oop-static_modifier-hard-q6

- Question Type: Java question

## Question Text

Animals are an important part of farm life and require a lot of food. Write a Java class called `Farm` to keep track of 
the animals and available food using the requirements below. Then write a class called `TestFeeding` to test the `Farm` 
class using the next set of requirements below.

## Farm Class

Your `Farm` class must have the following requirements:

- Attributes:
    - Note that none of the attributes should be visible from other classes.
    - A _static_ `double` called **foodInSilo**. This represents the total amount of food available in the silo for
      `Farm` objects, and should be set initially to 50 without having to call the constructor.
    - A `double` called **amountPerAnimal** which is the amount of the food needed for each animal.
    - An `int` called **numAnimals** which is the number of animals in the farm.

- Constructors:
    - A constructor that is accessible from other methods, and accepts a `double` and an `int` as parameters to set the
      **amountPerAnimal** and **numAnimals** attribute of the object.

- Methods:
    - Note that all methods in this class should be visible from another class
    - A `foodNeeded` method which returns a `double` equal to the value of **amountPerAnimal** multiplied by **numAnimals**
      which represents the total amount of food needed by the `Farm` object.
    - A `feedAnimals` method which prints "Animals fed and happy" if the total food needed is less than the
      amount available in the **foodInSilo** variable, subtracts the value from the available food, and returns true. 
      If there is not enough food it should print "We need to buy more food", subtract nothing, and returns false.

## TestFeeding Class

Your `TestFeeding` class must have the following items:

- Main method:
    - A `main` method which initializes 3 `Farm` objects with the following **amountPerAnimal** amounts in order:
      0.5, 0.2, 1 and following **numAnimals** numbers in order: 10, 20, 50. Then in a loop from first to third farm
      it should try to donate food by printing "Try to feed animals here... " and using **feedAnimals** method until there
      can not be any food donated. Then it should print "There is no more food left today." All messages should be
      printed on separate lines.
