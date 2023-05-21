# oop-object_independence-hard-q2

- Java question

## Question Text

Wear and tear happens to things that get used over a long period of time. Suppose you ran a museum, and you wanted to 
keep track of the quality of several `Painting` objects. Using the requirements below, create two classes, one called 
`Painting` to model the game and one called `TestMuseum` to use it.

## Painting Class

Your `Painting` class must have the following items:

- Attributes:
    - A `String` attribute called **name**
    - A `String` attribute called **quality**
    - Note that both of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class which accepts the parameters `String, String` and sets the **name**
      and **quality** attributes with the passed values.

- Methods (all the following methods should be visible from another class):
    - A method called `getName` that returns the value of the **name** attribute
    - A method called `getQuality` that returns the value of the **quality** attribute
    - A method called `setName` that accepts a `String` as a parameter, updates the **name** attribute to the passed 
     value, and returns nothing
    - A method called `setQuality` that accepts a `String` as a parameter, updates the **quality** attribute to the
      passed value, and returns nothing
    - A `toString` method which returns a `String` of the form `"The item x is of y quality."` where x is the value
      of the **name** attribute and y is the value of the **quality** attribute

# TestMuseum Class

Your `TestMuseum` class must have the following items:

- Main Method:
    - The main method should initialize two `Painting` objects
    - The first object should have a **name** of `The Starry Night` and a **quality** of `good`
    - The second object should have a **name** of `The Scream` and a **quality** of `poor`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Print `Some time passed…`
    - Next, using the `setQuality` method, update the **quality** attribute of the first object to `fair`
    - Finally, print the `toString` of both objects again. If the **quality** of the object is `poor` print `This needs 
      cleaning.`
    - Make sure that each of the four `toString` results and any messages are printed on their own line

