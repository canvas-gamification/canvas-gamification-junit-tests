# oop-object_independence-hard-q6

- Java question

## Question Text

Most food goes bad over time. When it does go bad, it should be thrown out. Using the requirements below, create
two classes, one called `Lasagna` to model the game and one called `TestFood` to use it.

## Lasagna Class

Your `Lasagna` class must have the following items:

- Attributes:
    - A `boolean` attribute called **isBad** 
    - A `boolean` attribute called **inGarbage**
    - A `double` attribute called **hoursSinceMade**
    - Note that none of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class which accepts the parameters `boolean, boolean, double` and sets the 
      **isBad**, **inGarbage** and **hoursSinceMade** attributes with the passed values.
    - This constructor should be visible to other classes

- Methods (all the following methods should be visible from another class):
    - A method called `getIsBad` that returns the value of the **isBad** attribute
    - A method called `getInGarbage` that returns the value of the **inGarbage** attribute
    - A method called `getHoursSinceMade` that returns the value of the **hoursSinceMade** attribute
    - A method called `gettingOld` that updates the **isBad** attribute to `true` and returns nothing
    - A method called `throwFood` that updates the **inGarbage** attribute to `true` and returns nothing
    - A `toString` method which returns a `String` of the form `"The dish was made x hours ago. Is it bad? y. Has it 
      been thrown out? z."` where x is the value of the **hoursSinceMade** attribute, y is the value of the **isBad** 
      attribute, and z is the value of the **inGarbage** attribute.

# TestFood Class

Your `TestFood` class must have the following items:

- Main Method:
    - The main method should initialize five `Lasagna` objects
    - The first object should have an **isBad** of `false`, an **inGarbage** of `false` and an **hoursSinceMade** of `
      0.0`
    - The second object should have an **isBad** of `false`, an **inGarbage** of `false` and an **hoursSinceMade** of 
      `1.0`
    - The third object should have an **isBad** of `false`, an **inGarbage** of `false` and an **hoursSinceMade** of 
      `3.8`
    - The fourth object should have an **isBad** of `false`, an **inGarbage** of `false` and an **hoursSinceMade** of 
      `2.76`
    - The first object should have an **isBad** of `false`, an **inGarbage** of `false` and an **hoursSinceMade** of 
      `1.8`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Then print `"Some time passed..."`
    - Next, use the `gettingOld` method to update the **isBad** attribute of the first object and third object
    - Use the `throwFood` method to update the **inGarbage** attribute of any objects with an **isBad** value of `true`
    - Finally, print the `toString` of all objects again.
    - Make sure that each of the messages and `toString` results are printed on their own line
    