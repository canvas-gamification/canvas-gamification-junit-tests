# oop-special_class_method-medium-q13

## Question Text

You are developing a wholesale application consisting of items that can be purchased in large quantities. Make a Java 
class called **Detergent** to model such an instance using the requirements below:

### Detergent Class:

Your `Detergent` class already has the following items:

- Attributes:
    - A `double` called **volume**
    - A `String` called **manufacturer**
    - These are not visible from other classes

- Constructor:
    - a `Detergent` constructor that is visible to other classes and accepts a `double` and a `String` and uses them to
      initialize the **volume** and **manufacturer** attributes.

You need to add the following items:

- Methods:
    - a `setManufacturer` method which accepts a `String` and uses it to set the value of the **manufacturer** attribute
    - a `getManufacturer` method which returns the value stored in the **manufacturer** attribute
    - These methods must be visible from other classes.