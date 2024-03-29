# oop-special_class_method-medium-q4

## Question Text

You are about to write a program that can grow and breed different things, and you can control how they evolve. Make a 
Java class called `Plant` that represents something you grow with the following description.


### Plant

Your `Plant` class already has the following items:

- Attributes:
    - a `String` called **breed** that is not accessible from other classes.

- Constructor:
    - a `Plant` constructor that is visible to other classes and accepts a `String` and uses it to initialize the
      **breed** attribute

You need to add the following items:

- Methods:
    - a `setBreed` method which accepts a `String` and uses it to set the value of the **breed** attribute
    - a `getBreed` method which returns the value stored in the **breed** attribute
    - a `toString` method which return the string `"My breed is x"` where x is the value of **breed**
    - All of these methods should be visible from another class.
    - All the setter methods must not return anything.