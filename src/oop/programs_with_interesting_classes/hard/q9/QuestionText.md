# oop-programs_with_interesting_classes-hard-q9

- Java Question

## Question Text

In the old days library books had cards inside them that marked who had checked them out, and it was often fun to flip 
to the back of them to see who signed out certain books before you. Let's make a Java program that simulates this 
effect! You are provided with the test class `Library` that creates a `Book` that several `Borrower`s check out.
Your task is to create the `Book` and `Borrower` classes. More details below.

### Borrower Class

Your `Borrower` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - a `String` attribute called **date**
    - both of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept two `String` values to initialize the **name** and **date** attributes in that
      order.
    - The constructor should be accessible from another class.

- Methods:
    - A `toString` method which is visible from another class and returns a `String` in the form of "x signed on y"
      where x is the value of the **name** attribute and y is the value of the **date** attribute.

### Book Class

Your `Book` class must have the following requirements:

- Attributes:
    - a `Borrower[]` attribute called **borrowers**
    - an `int` attribute called **usedSpaces**
    - a `String` attribute called **title**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` to initialize the **title** attribute, and initialize the **borrowers**
      attribute to an empty array of size 10, and the **usedSpaces** attribute to `0`.
    - The constructor should be accessible from another class.

- Methods:
    - If there is no return type specified for the following methods, assume it should return nothing.
    - An `expand` method which should not be visible from other classes. It should double the length of the **borrowers**
      array while retaining the elements and their positions inside the array it.
    - A `signOut` method should be visible from other classes and accept a `Borrower` as a parameter. This method should
      check that **usedSpace** is not greater than or equal to the length of the **borrowers** array. If it is, it should
      call the `expand` method. Finally, the method should add the `Borrower` at the first open space and increment the
      **usedSpace** attribute.
    - A `toString` method which returns a `String` in the form of 
      ```
        "Title: x
        a1 signed on a2
        b1 signed on b2
        ...
        z1 signed on z2
        "
      ```
      where x is the value of **title** and each of the `Borrower` objects in the **borrowers** array has their 
      `toString` printed on its own line with an extra line at the end of the list. (With the letters a-z representing
      a specific `Borrower` object with 1 as their **name** and 2 their **date**)
