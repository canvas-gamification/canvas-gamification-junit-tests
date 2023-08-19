# oop-special_class_method-medium-q6

### Scissors:

Your `Scissors` class already has the following items:

- Attributes:
    - a `boolean` called **isSharp** that is not accessible from another class.
    - a `boolean` called **outOfReach** that is not accessible from another class.

- Constructor:
    - a `Scissors` constructor that is visible to other classes and accepts two `boolean` and uses it to initialize the
      **isSharp** and **outOfReach** attributes in that order.

You need to add the following items to the class:

- Methods:
    - a `setIsSharp` method which accepts a `boolean` and uses it to set the value of the **isSharp** attribute
    - a `getIsSharp` method which returns the value stored in the **isSharp** attribute
    - a `setOutOfReach` method that accepts a `boolean` and uses it to set the value of the **outOfReach** attribute
    - a `getOutOfReach` method which returns the value stored in the **outOfReach** attribute
    - Note that the setter methods should have a void return type.
    - a `toString` method which returns the string `"isSharp is x and outOfReach is y"` where x is the isSharp attribute and y is the outOfReach attribute.
    - All of these methods must be accessible from another class.