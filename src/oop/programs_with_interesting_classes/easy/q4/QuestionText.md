# oop-programs_with_interesting_classes-easy-q4

- Parsons Question

## Question Text

Life is a beautiful thing, and as time passes, things grow. Write a Java class about plants called `Tree`.

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
    - A accessor and mutator methods for the **type** attribute called `getType` and `setType`.
    - A accessor and mutator methods for the **size** attribute called `getSize` and `setSize`.
    - A `gettingOlder` method which addes 4 to the **size** attribute.
    - A `toString` method that returns `This is a x tree with y centimeters in diameter.` where x is the value of the
      **type** attribute and y is the value of the **size** attribute.