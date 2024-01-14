# oop-object_independence-hard-q1

- Java question

## Question Text

Suppose you wanted to model a platform game that you and your friends play in Java. Using the requirements below, create
two classes, one called `PlatformGame` to model the game and one called `TestPlatformGame` to use it.

## PlatformGame Class

Your `PlatformGame` class must have the following items:

- Fields:
    - An `int` field called **numLevels**
    - A `String` field called **difficulty**
    - Note that both of these fields should not be accessible from another class

- Constructor:
    - A constructor visible from another class which accepts the parameters `int, String` and sets the **numLevels**
      and **difficulty** fields with the passed values.

- Methods (all the following methods should be visible from another class):
    - A method called `getNumLevels` that returns the value of the **numLevels** field
    - A method called `getDifficulty` that returns the value of the **difficulty** field
    - A method called `setNumLevels` that accepts an `int` as a parameter, updates the **numLevels** field to the
      passed value, and returns nothing
    - A method called `setDifficulty` that accepts an `String` as a parameter, updates the **difficulty** field to
      the passed value, and returns nothing
    - A `toString` method which returns a `String` of the
      form `"This game has x levels and is rated to be y difficulty."` where x is the value of the **numLevels** field
      and y is the value of the **difficulty** field

# TestPlatformGame Class

Your `TestPlatformGame` class must have the following items:

- Main Method:
    - The main method should initialize two `PlatformGame` objects
    - The first object should have a **difficulty** of `easy` and a **numLevels** of `3`
    - The second object should have **difficulty** of `hard` and a **numLevels** of `10`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Next, using the `setNumLevels` method, update the **numLevels** field of the first object to 5
    - Finally, print the `toString` of both objects again.
    - Make sure that each of the four `toString` results are printed on their own line
    