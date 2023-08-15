# oop-object_independence-hard-q3

- Java question

## Question Text

Suppose you wanted to model the different kinds of plants present in an environment. Using the requirements below, 
create two classes, one called `Tree` and its test class `TestFoliage`.

## Tree Class

Your `Tree` class must have the following items:

- attributes:
    - A `boolean` attribute called **isRare**
    - A `double` attribute called **height**
    - Note that none of these attributes should be accessible from another class

- Constructor:
    - A constructor visible from another class which accepts the parameters `boolean, double` and sets the **isRare** 
      and **height** attributes with the passed values.
    - This constructor should be visible to other classes

- Methods (all the following methods should be visible from another class):
    - A method called `getIsRare` that returns the value of the **isRare** attribute
    - A method called `getHeight` that returns the value of the **height** attribute
    - A method called `setIsRare` that accepts an `boolean` as a parameter, updates the **isRare** attribute to the 
      passed value, and returns nothing
    - A method called `setHeight` that accepts a `double` as a parameter, updates the **height** attribute to the passed
      value, and returns nothing
    - A method called `deforestation` that updates the **height** value to 0. It has no parameters and does not return anything.
    - A `toString` method which returns a `String` of the form `"This tree’s rarity is x, and is ym tall"` where x is
      the value of the **isRare** attribute, y is the value of the **height** attribute (m signifies meters)

# TestFoliage Class

Your `TestFoliage` class must have the following items:

- Main Method:
    - The main method should initialize two `Tree` objects
    - The first object should have a `true` **isRare** and a **height** of `50.5`
    - The second object should have a `false` **isRare** and a **height** of `20.4`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Next, use the `deforestation` method on the first object
    - Finally, print the `toString` of both objects again.
    - Make sure that each of the four `toString` results are printed on their own line