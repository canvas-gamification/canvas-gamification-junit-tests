# oop-special_class_method-medium-q6

## Question Text

Teaching children to stay away from sharp objects is an important lesson. Make a Java class called `Scissors` that has
two attributes called **isSharp** and **canCut**. This class has a constructor that initializes the two attributes,
accessor and mutator methods for each attribute.

### Scissors:

Your `Scissors` class must have the following items

- Attributes:
    - a `boolean` called **isSharp** that is not accessible from another class.
    - a `boolean` called **canCut** that is not accessible from another class.

- Constructor:
    - a `Scissors` constructor that is visible to other classes and accepts two `boolean` and uses it to initialize the
      **isSharp** and **canCut** fields in that order.

You need to add the following items to the class:

- Methods:
    - a `setIsSharp` method which accepts a `boolean` and uses it to set the value of the **isSharp** attribute
    - a `getIsSharp` method which returns the value stored in the **isSharp** attribute
    - a `setCanCut` method which accepts a `boolean` and uses it to set the value of the **canCut** attribute
    - a `getCanCut` method which returns the value stored in the **canCut** attribute
    - a `toString` method which returns the string `"isSharp is " + isSharp + " and canCut is " + canCut`
    - All of these methods must be accessible from another class.