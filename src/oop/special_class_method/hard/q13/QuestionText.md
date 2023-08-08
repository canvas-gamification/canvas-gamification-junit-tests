# oop-special_class_method-hard-q13

## Question Text

Suppose you were hired by a departmental store to digitize their catalogue system, and one of the classes you are making
for objects is a **Cup** class. This class has three attributes called **liquid**, **color** , and **volume**.

### Cup Class:

Your `Cup` class must have the following items:

- Attributes:
    - A `String` called **colour**
    - A `double` called **volume**
    - A `String` called **liquid**
    - These are not visible from other classes

- Constructor:
    - a `Cup` constructor that is visible to other classes and accepts a `String`, a `double` and another `String` and
      uses it to initialize the **colour**, **volume**, and **liquid** attributes.

- Methods:
    - a `setLiquid` method which accepts a `String` and uses it to set the value of the **liquid** attribute
    - a `getVolume` method which returns the value stored in the **volume** attribute
    - These methods must be visible from other classes.
  
### Distractors

    - public void setColour(String a)
    - public void setVolume(double a)
    - public String colour;
    - private String volume;
    - public String liquid;
    - this.colour = a;
    - this.volume = a;
    - return this.liquid = a;
    - {
    - }
