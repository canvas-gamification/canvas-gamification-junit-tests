# oop-static_modifier-medium-q5

- Question Type: Java

## Question Text

As the manager of a local apparel store, you are tasked with modeling your store's selection. Write a Java program
called `Hat`  to model the hats you have in the store using the requirements below. Then write a class called `Test` to
test `Hat` based on the second set of requirements below.

### Hat Class

Your `Hat` class already has the following items:

- Attributes:
    - A `String` attribute called **colour** that cannot be accessed in other classes

- Constructors:
    - A constructor that accepts a `String` and initializes the **colour** attribute.
    - This constructor is accessible from other classes.

You need to add the following items:

- Attributes:
    - A `String` attribute called **companyName** that has its value, initially `Nike`, shared by all **Hat** instances,
      and is not visible from another class.


- Methods:
    - a `toString` method, that is visible from other classes, which returns a String of the information about the `Hat`
      class in the form `This is a x Hat that is y in colour` where x is the value of the **companyName** attribute and
      y is the value of the **colour** attribute

### Test Class:

Your `Test` class should have a main method which initializes a `Hat` object of **colour** value of `"Green"`. Then,
print the object on its own line using the toString method.