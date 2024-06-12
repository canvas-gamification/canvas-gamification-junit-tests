# oop-special_class_method-medium-q12

Java question

### Question Text:

Customers love to shop online instead of driving to the store. Department stores need a system to model their current 
and past inventory so it can be displayed online. Use the requirements below to write a Java class **Shirt** to keep 
track of clothing in a store.

### Shirt Class:

Your `Shirt` class already has the following items:

- Attributes:
    - An `int` called **size**
    - An `int` called **yearMade**
    - These are not visible from other classes

- Constructor:
    - a `Shirt` constructor that is visible to other classes and has two `int` parameters. The first initializes
      the **size** attribute and the second the **yearMade** attribute.

You need to add the following items:

- Methods:
    - a `displaySize` method which returns nothing and prints a `String` in the format of `The size is x` where x is 
      the value of **size** only if the value of **yearMade** is greater than 2000. Otherwise, it should print 
      `This shirt is no longer carried`.
    - a `getSize` method which returns the value stored in the **size** attribute.
    - both methods should be visible to other classes.