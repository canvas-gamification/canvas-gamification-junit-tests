# oop-special_class_method-medium-q5

## Question Text

It's April fool's day and you want to change how the calculator works, so you can trick your Math teacher. Make a Java
class called `Calculator` that has two attributes called **sum** and **isCorrect** whose values are initialized in the
constructor. In particular, **sum** is set to the input parameter times 7. The class also has an accessor and mutator
method for each attribute.

### Calculator:

Your `Calculator` class must have the following items

- Attributes:
    - a `double` called **sum** that is not accessible from another class
    - a `boolean` called **isCorrect** that is not accessible from another class

- Constructor:
    - a `Calculator` constructor that is visible to other classes and accepts a `double` and a `boolean` and uses it to
      initialize the **sum** and **isCorrect** attributes with **sum** being 7 multiplied by the input value.

You need to add the following items:

- Methods:
    - a `setSum` method which accepts a `double` and uses it to set the value of the **sum** attribute
    - a `getSum` method which returns the value stored in the **sum** attribute
    - a `setIsCorrect` method which accepts a `boolean` and uses it to set the value of the **isCorrect** attribute
    - a `getIsCorrect` method which returns the value stored in the **isCorrect** attribute
    - a `toString` method which returns the string `"The sum is " + sum + " and it is " + isCorrect`
    - These methods should be accessible from other classes.
