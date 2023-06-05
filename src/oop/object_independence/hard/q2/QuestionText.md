# oop-object_independence-hard-q2

- Java question

## Question Text

Suppose you wanted to model an aquarium you visited. Using the requirements below, create two classes, one called `Fish` 
to model the animals in the aquarium and one called `TestAquarium` to use it.

## Fish Class

Your `Fish` class must have the following items:

- attributes:
    - A `String` attribute called **colour**
    - A `String` attribute called **gender**
    - An `int` attribute called **age**
    - Note that none of these attributes should be accessible from another class

- Constructor:
    - A constructor visible from another class which accepts the parameters `String, String, int` and sets the 
      **colour**, **gender**, and **age** attributes with the passed values.
    - This constructor should be visible to other classes

- Methods (all the following methods should be visible from another class):
    - A method called `getAge` that returns the value of the **age** attribute
    - A method called `getColour` that returns the value of the **colour** attribute
    - A method called `getGender` that returns the value of the **gender** attribute
    - A method called `setAge` that accepts an `int` as a parameter, updates the **age** attribute to the passed value, and
      returns nothing
    - A method called `setColour` that accepts a `String` as a parameter, updates the **colour** attribute to the passed
      value, and returns nothing
    - A method called `setGender` that accepts a `String` as a parameter, updates the **gender** attribute to the passed
      value, and returns nothing
    - A `toString` method which returns a `String` of the form `"This fish is x, and is y, and is z years old."`
      where x is the value of the **colour** attribute, y is the value of the **gender** attribute, and z is the value of the
      **age** attribute.

# TestAquarium Class

Your `TestAquarium` class must have the following items:

- Main Method:
    - The main method should initialize three `Fish` objects
    - The first object should have a **colour** of `Blue`, a **gender** of `Male`, and an **age** of `2`
    - The second object should have **colour** of `White`, a **gender** of `Female`, and an **age** of `4`
    - The third object should have a **colour** of `Red`, a **gender** of `Female`, and an **age** of `3`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Next, using the `setAge` method, update the **age** attribute of all objects to be 10 higher
    - Finally, print the `toString` of both objects again.
    - Make sure that each of the six `toString` results are printed on their own line
    