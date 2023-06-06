# oop-special_class_method-medium-q4

## Question Text

You are about to write a program that can grow and breed different things, and you can control how they evolve. Make a 
Java class called `Plant` that has a String attribute called **breed** which is initialized in the constructor. The class 
also includes an accessor and a mutator for each attribute.


### Plant

Your `Plant` class must have the following items

- Attributes:
    - a `String` called **breed** that is not accessible from other classes.

- Constructor:
    - a `Plant` constructor that is visible to other classes and accepts a `String` and uses it to initialize the
      **breed** attribute
    - It must not be visible from another class.

You need to add the following items:

- Methods:
    - a `setBreed` method which accepts a `String` and uses it to set the value of the **breed** attribute
    - a `getBreed` method which returns the value stored in the **breed** attribute
    - a `toString` method which return the string `"My breed is " + breed`
    - None of these methods should be visible from another class.