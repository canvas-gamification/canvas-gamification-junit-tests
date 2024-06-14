# oop-special_class_method-medium-q13

## Question Text

You are developing a wholesale application that facilitates the purchasing of items in large quantities. Using the 
requirements below, write a Java class called **Detergent** to model the details of one product.

### Detergent Class:

Your `Detergent` class already has the following items:

- Attributes:
    - A `double` called **volume**
    - A `String` called **manufacturer**
    - These are not visible from other classes

- Constructor:
    - a `Detergent` constructor that is visible to other classes and accepts a `double` and a `String` and uses them to
      initialize the **volume** and **manufacturer** attributes respectively.

You need to add the following items:

- Methods:
    - a `setManufacturer` method which accepts a `String` and uses it to set the value of the **manufacturer** attribute
      and must return nothing.
    - a `getManufacturer` method which returns the value stored in the **manufacturer** attribute.
    - a `toString` method which returns a `String` of the format "xml of y Detergent" where x is **volume** and y is
      **manufacturer**.
    - These methods must be visible from other classes.