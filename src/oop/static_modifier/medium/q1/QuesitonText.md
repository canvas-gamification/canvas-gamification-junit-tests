# oop-static_modifier-medium-q1

- Question Type: Java

## Question Text

Suppose you want to model a circle and track how many circles you have. Use the requirements below to code a `Circle`
class in Java

### Circle Class

Your `Circle` class must have the following items:

- Attributes:
    - An `int` attribute called **count** which tracks the total number of `Circle` objects created
    - A `double` attribute called **radius**
    - Note that all attributes in this class should be private

- Constructors:
    - A contractor that accepts a `double` as a parameter to initialize the **radius** field of the `Circle`
    - The constructor must also increment the total number of `Circle` objects created and should be visible from
      another class

- Methods:
    - A `getCounter` method which returns the **count** field and should be visible from another class
