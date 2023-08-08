# oop-special_class_method-medium-q11

## Question Text

Many appliances and electronic devices have an internal mechanism to moderate temperature. Make a Java class called
**Oven** that has attributes **currTemp**, **size**, and **colour** that specify different properties of the **Oven**.

### Oven Class:

Your `Oven` class already has the following items:

- Attributes:
    - A `double` called **currTemp**
    - A `double` called **size**
    - A `String` called **colour**
    - These are not visible from other classes

- Constructor:
    - An `Oven` constructor that is visible to other classes and accepts two `double` and a `String` and uses it to
      initialize the **currTemp**, **size**, and **colour** attributes.
- Methods:
    - Getter methods for **size** and **colour** attributes, and getter and setter method for **currTemp** attribute.

You need to add the following items:

- Methods:
    - a `toString` method which returns the string `"The z Oven with size of y has the tempeture of x` where x is
      the value of **currTemp**, y is the value of **size**, and z is the value of **colour**.
    - Two methods called `powerDecrease` and `powerIncrease` where the `powerDecrease` method decreases the value of **currTemp** by 10
      and the `powerIncrease` method increases the value of **currTemp** by 10.
    - A `changePower` method which call the `powerDecrease` method if the value of the **currTemp** attribute is more than 100, and
      call the `powerIncrease` otherwise.
    - These methods must be visible from other classes.