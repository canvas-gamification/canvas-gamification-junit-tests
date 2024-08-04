# oop-programs_with_interesting_classes-medium-q3

- Parsons Question

## Question Text

You are playing a game where you can catch, fight, and explore the world with creature companions. Make a Java class 
called `Pokemon` to model the creatures and battle actions, and a class called `TestPokemon` to test it using the 
requirements below.

### Pokemon Class

Your `Pokemon` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - a `String` attribute called **type**
    - an `int` attribute called **health**
    - an `int` attribute called *experienceLevel*
    - an `int` attribute called *evolveLevel*
    - a *final* `int` attribute called *BASE*
    - a *final* `int` attribute called *INTERMEDIATE*
    - a *final* `int` attribute called *ADVANCED*
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String`, a `String` and an `int` in that order to initialize the **name**, **type**
      and **experienceLevel** attributes.
    - It should also initialize the **health** attribute to 100 and the **evolveLevel** attribute to **BASE**
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `setHealth` method which accepts an `int` and updates the **health** attribute to that value.
    - A `getHealth` method which returns the **health** attribute
    - A `setName` method which accepts a `String` and updates the **name** attribute to that value
    - A `getName` method which returns the value of the **name** attribute
    - A `toString` method that returns a String of the form "w is a x type creature with y experience and has evolved to
      z" where w is the value of the **name** attribute, x is the value of the **type**, y is the value of the
      **experienceLevel** attribute, and z is the value of the **evolveLevel** attribute
    - An `attack` method which accepts another `Pokemon` object as a parameter. The creature uses one-tenth of its 
      health and attacks the opponent. The opponent will receive that hit by subtracting the value from its own health. 
      If the power used is more than 10, then the method should display that the attack is effective, otherwise, it 
      displays the attack was not effective. Having carried out an attack, the creature loses one health point, and the 
      method calls `battleExp` with half of the power of the attack as the experience gained from this attack.
    - A `battleExp` method which accepts an `int` as a parameter and increases the value of the **experienceLevel** by
      that amount. It should then call the `checkEvolution` method.
    - A `checkEvolution` method that checks if the value of the **experienceLevel** attribute is sufficient to evolve.
      If the value is less than 16 it should remain at **BASE**, it is greater than or equal to 16 but less than 32
      it should advance to **INTERMEDIATE**, and if it is greater than or equal to 32 it should advance to **ADVANCED**


### TestPokemon Class

Your `TestPokemon` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize two `Pokemon` objects. The first should be named `"Squirtle"` with a type of `"Water"` and an
      experience level of `5`. The other must be named `"Charmander"` with a type of `"Fire"` and an experience level
      of `6`.
    - Then, print a statement marking the beginning of the battle.
    - After, call the `attack` method on the `Pokemon` with the first creature attacking the second creature, then the
      second creature attacking the first.
    - Finally, print the end of the battle and the result of the `toString` of each of the creatures in the same order
      as they attacked each other.
