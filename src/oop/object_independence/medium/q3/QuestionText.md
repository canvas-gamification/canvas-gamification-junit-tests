# oop-object_independence-medium-q3

## Question Info

- Question type: Java

### Question Text

Your goal is to become a master chef so you make a mobile app to keep track of all your secret recipes. Make a class
called Cocktail with the following description:

### Cocktail Class

Your `Cocktail` class must have the following items:

- Attributes:
    - An array of `String` called **ingredients**
    - Note that this attribute should not be visible from another class

- Constructors:
    - A single constructor with a parameter of an array of `String` that initializes the **ingredients** attribute
    - This constructor should be visible from another class

- Methods:
    - a `getIngredients` method which is accessible from other classes and returns the array **ingredients** attribute
    - a `setIngredients` method which accepts an array of `String` value, updates the **ingredients** attribute with it,
      and is accessible from other classes
    - a `toString` method which returns a String of the information about the `Cocktail` class of the form
      `My ingredients are: A B C D ...` ,where A, B, C, and D represent the strings in order in the **ingredients**
      attribute, and is visible from other classes.
    - Note that all setter methods must not return any value

### TestRecipe Class

Your `TestRecipe` class must have the following items:

- Methods:
    - A `main` method which initializes two **Cocktail** objects, one with **ingredients** Pineapple Juice and Coconut
      Milk the other with Apple Juice then change the **ingredients** of the latter object to Apple Juice and Almond Milk.
      Then, Print them in order using **toString** method.