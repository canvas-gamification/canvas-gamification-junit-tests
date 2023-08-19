# oop-special_class_method-medium-q5

### Calculator:

Your `Calculator` class already has the following items:

- Attributes:
    - a `double` called **sum** that is not accessible from another class
    - a `boolean` called **isCorrect** that is not accessible from another class

- Constructor:
    - a `Calculator` constructor that is visible to other classes and accepts a `double` and a `boolean` and uses it to
      initialize the **sum** and **isCorrect** attributes with **sum** being 7 multiplied by the input value.

You need to add the following items:

- Methods:
    - a `setSum` method, with void return type, which accepts a `double` and uses it to set the value of the **sum**
      attribute
    - a `getSum` method which returns the value stored in the **sum** attribute
    - a `setIsCorrect` method, with void return type, which accepts a `boolean` and uses it to set the value of the
      **isCorrect** attribute
    - a `getIsCorrect` method which returns the value stored in the **isCorrect** attribute
    - a `toString` method which returns the string `"The sum is  x and it is y"` where x is the value
      of **sum** and y is the value of **isCorrect**.
    - These methods should be accessible from other classes.
