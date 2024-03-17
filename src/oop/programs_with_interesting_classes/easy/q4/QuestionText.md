# oop-programs_with_interesting_classes-easy-q4

- Parsons Question

## Question Text

Life is a beautiful thing, and as time passes, things grow. Write a Java class about plants called `Tree` to model a plant with the requirements below:

### Tree Class

The `Tree` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - A `String` attribute called **type**
    - A `double` attribute called **size**

- Constructors:
    - A constructor visible from another class that accepts a `String` and a `double` as parameters, and uses the values
      to initialize the **type** and **size** attributes
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `gettingOlder` method which addes 4 to the **size** attribute.
    - A `toString` method that returns `This is a x tree with y centimeters in diameter.` where x is the value of the
      **type** attribute and y is the value of the **size** attribute.
    - A `getType` method which returns the value of **type** attribute.
    - A `getSize` method which returns the value of **size** attribute.
    - A `setType` method, which returns nothing, and gets a String and changes the value of **type** to input value.
    - A `setSize` method, which returns nothing, and gets a double and changes the value of **size** to input value.