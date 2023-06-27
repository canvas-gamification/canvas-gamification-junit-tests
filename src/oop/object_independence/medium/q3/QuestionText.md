# oop-object_independence-medium-q3

## Question Info

- Question type: Parsons

## Question Text

You want to become a master chef so you make a mobile app to keep track of all your secret recipes. Make a class
called **Cocktail** with one attribute called **ingredients** which represents a list of ingredients and are initialized
in the constructor. The method also has an accessor, mutator, and a **toString()** method.

### Cocktail Class

Your `Cocktail` class must have the following items:

- Attributes:
    - An array of `String` called **ingredients**
    - Note that neither of these attributes should be visible from another class

- Constructors:
    - A single constructor with a parameter of an array of `String` that initalzies the **ingredients** attribute
    - This constructor should be visible from another class

- Methods:
    - a `getIngredients` method which is accessible from other classes and returns the array **ingredients** attribute
    - a `setIngredients` method which accepts an array of `String` value, updates the **ingredients** attribute with it,
      and is accessible from other classes
    - a `toString` method which returns a String of the information about the `Cocktail` class of the form
      `My ingredients are: A B C D ...` ,where A, B, C, and D represent the strings in order in the **ingredients**
      attribute, and is visible from other classes.

### TestWaitList Class

Your `TestWaitList` class must have the following items:

- Methods:
    - A `main` method which initializes two PhoneWaitList objects, one with a **numAhead** of 5 and
      the other with a **numAhead** of 2 and print them using **toString** method.