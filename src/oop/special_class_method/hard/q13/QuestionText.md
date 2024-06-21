# oop-special_class_method-hard-q13

## Question Text

Suppose you were hired by a department store to digitize their catalogue system. Using the requirements below, make a
Java class called **Cup** to model one of the objects in their catalogue. 

### Cup Class:

Your `Cup` class must have the following items:

- Attributes:
    - A `String` called **colour**
    - A `double` called **volume**
    - A `String` called **liquid**
    - These should not be visible from other classes

- Constructor:
    - a `Cup` constructor that is visible to other classes and accepts a `String`, a `double` and another `String` and
      uses it to initialize the **colour**, **volume**, and **liquid** attributes.

- Methods:
    - a `setLiquid` method which accepts a `String` and uses it to set the value of the **liquid** attribute. It must
      not return anything.
    - a `getVolume` method which returns the value stored in the **volume** attribute.
    - a `toString` method which returns a `String` of the format "The x Cup has yml of z" where x is **colour**, y is
      **volume** and z is **liquid**.
    - These methods must be visible from other classes.

### Distractors 

    - public void setColour(String a) *
    - public void setVolume(double a) *
    - public void toString()
    - public String colour;
    - private String volume;
    - public String liquid;
    - this.colour = a;
    - this.volume = a;
    - return this.liquid = a;
    - this.liquid = A;
    - this.colour = volume;
    - {
    - }
