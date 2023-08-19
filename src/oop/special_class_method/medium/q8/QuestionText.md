# oop-special_class_method-medium-q7

### Luffy Class:

Your `Luffy` class already has the following items

- Attributes:
    - An `String` called **skill**
    - An `int` called **bounty**
    - These are not visible from other classes

- Constructor:
    - a `Luffy` constructor that is visible to other classes and accepts a `String` and an `int` and uses it to
      initialize the **skill** and **bounty** attributes.

You need to add the following items:

- Methods:
    - a `setSkill` method which accepts a `String` and uses it to set the value of the **skill** attribute
    - a `getSkill` method which returns the value stored in the **skill** attribute
    - a `setBounty` method which accepts an `int` and uses it to set the value of the **bounty** attribute
    - a `getBounty` method which returns the value stored in the **bounty** attribute
    - Note that all setter methods must have a void return type.
    - a `toString` method which returns the string `"My special skill is x and my bounty is y"` where x is
      the value of **skill** and y is the value of **bounty**.
    - These methods must be visible from other classes.