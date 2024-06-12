# oop-special_class_method-medium-q11

Java question

## Question Text

Some appliances and electronic devices have an internal mechanism to moderate temperature. Many of these appliances 
are frequently found in a kitchen and must be monitored by the cook. Using the requirements below, write a Java class 
called **Oven** to keep track of the appliance's status.

### Oven Class:

Your `Oven` class already has the following items:

- Attributes:
    - A `double` called **currTemp**
    - A `double` called **size**
    - A `String` called **colour**
    - These are not visible from other classes

- Constructor:
    - An `Oven` constructor that is visible to other classes and has two `double` parameters and a `String` parameter. 
      The first `double` is used to initialize the **currTemp** attribute and the second one initializes the **size**
      attribute. The `String` parameter is used to initialize the **colour** attribute.
  
- Methods:
    - Getter methods for **size**, **colour**, and **currTemp** attributes.
    - Setter method for **currTemp** attribute.

You need to add the following items:

- Methods:
    - a `toString` method which returns the string `"The z Oven with size of y has the temperature of x` where x is
      the value of **currTemp**, y is the value of **size**, and z is the value of **colour**.
    - Two methods called `powerDecrease` and `powerIncrease` where the `powerDecrease` method decreases the value of 
      **currTemp** by 10 and the `powerIncrease` method increases the value of **currTemp** by 10. They must not return 
      anything.
    - A `changePower` method which should call the `powerDecrease` method if the value of the **currTemp** attribute is 
      greater than 100, and otherwise it should call the `powerIncrease` method. They must not return anything.
    - These methods must be visible from other classes.