# oop-special_class_method-medium-q3

## Question Text

You want to write a program where you can control the volume of noisy objects. Make a Java class called `Speaker` that
has an attribute called **volume** which is initialized in the constructor. The class also includes an accessor and a
mutator for each attribute.

### Speaker

You are provided with the following items:

- Attributes:
    - a `double` called **volume** that is not accessible from other classes.

- Constructor:
    - a `Speaker` constructor that is visible to other classes and accepts a `double` and uses it to initialize the
      **volume** attribute

You need to add the following items:

- Methods:
    - a `setVolume` method which accepts a `double` and uses it to set the value of the **volume** attribute
    - a `getVolume` method which returns the value stored in the **volume** attribute
    - a `toString` method which returns the string `"My volume is x"` where x is the value of **volume**
    - all these methods should be visible from other classes.
