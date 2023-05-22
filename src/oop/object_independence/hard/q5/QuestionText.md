# oop-object_independence-hard-q5

- Java question

## Question Text
Things break and fall all the time, but you always need to fix those things. Using the requirements below, create
two classes, one called `Glass` to model the breakable items and one called `TestFragile` to use it.

## Glass Class

Your `Glass` class must have the following items:

- Attributes:
    - A `String` attribute called **condition**
    - A `boolean` attribute called **isBroken**
    - A `double` attribute called **weight**
    - Note that all of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class which accepts the parameters `String, boolean, weight` and sets the 
      **condition**, **isBroken**, and **weight** attributes with the passed values.

- Methods (all the following methods should be visible from another class):
    - A method called `broken` that sets the value of the **isBroken** attribute to true
    - A method called `fix` that sets the value of the **isBroken** attribute to false
    - A `toString` method which returns a `String` of the form `"The item is x, and its weight is y and is it broken? 
      z"` where x is the value of the **condition** attribute, y is the value of the **weight** attribute, and z is the
      value of the **isBroken** attribute

# TestFragile Class

Your `TestFragile` class must have the following items:

- Main Method:
    - The main method should initialize three `Glass` objects
    - The first object should have a **condition** of `New`, an **isBroken** value of `false`, and a **weight** of `40.0`
    - The second object should have a **condition** of `Worn`, an **isBroken** value of `false`, and a **weight** of `32.9`
    - The third object should have a **condition** of `Old`, an **isBroken** value of `false`, and a **weight** of `813.25`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Next, using the `broken` method, update the **isBroken** attribute of the first object and third object
    - Print the `toString` value of each object again
    - Next, use the `fix` method to fix any broken objects.
    - Finally, print the `toString` of all objects again
    - Make sure that each of the `toString` results are printed on their own line
