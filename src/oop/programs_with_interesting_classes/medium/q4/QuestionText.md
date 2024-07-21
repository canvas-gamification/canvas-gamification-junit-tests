# oop-programs_with_interesting_classes-medium-q4

- Parsons Question

## Question Text

You are playing a platformer video game where your character jumps through Mushroom Kingdom collecting power-ups and
avoiding enemies. Make a Java class called `Mario` and `TestPlatformer` to model a run of this game.

### Mario Class

Your `Mario` class must have the following requirements:

- Attributes:
    - an `int` attribute called **jumpHeight**
    - a `boolean` attribute called **activePowerUp**
    - a `boolean` attribute called **isDead**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The first constructor should accept no parameters and initialize **jumpHeight** to `1` and **activePowerUp** and
      **isDead** to false.
    - The second constructor should accept an `int`, a `boolean` and a `boolean` in that order to initialize the 
      **jumpHeight**, **activePowerUp** and **isDead** attributes.
    - Both constructors should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `jump` method which returns the **jumpHeight** attribute
    - An `eatPowerUp` method which sets the value of **activePowerUp** to `true` and increases the value of **jumpHeight**
      by 5.
    - A `takeDamage` method which checks if **activePowerUp** is `true`. If so, set **activePowerUp** to `false` and 
      reduces the value of **jumpHeight** by 5. If **activePowerUp** is `false`, set **jumpHeight** to `0` and **isDead**
      to `true`.
    - A `toString` method which returns a `String` in the form of "I can jump x units high, my power up state is y, and I am z."
      where x is the value of **jumpHeight**, y is the value of **activePowerUp**, and z is "dead" if **isDead** is `true`
      and "still alive" if it is `false`.

### TestPlatformer Class

Your `TestPlatformer` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize one `Mario` object using the default constructor and then print it using the `toString` method.
    - Then, call the `eatPowerUp` method and print the `Mario` object on a new line.
    - After, call the `takeDamage` method on the `Mario` twice.
    - Finally, print the result of the `toString` for the `Mario` again.