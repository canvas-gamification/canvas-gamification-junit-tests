# oop-special_class_method-hard-q6

### Car Class:

Your `Car` class must have the following items:

- Attributes :
    - a `double` attribute named **topSpeed** which is not accessible from other classes
    - a `String` attribute named **type** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a`double` and a `String` to initialize the
      **topSpeed** and **type** attributes.
    - A constructor which is accessible from other classes without input to initialize the
      **topSpeed** and **type** attributes to 180 and null.

- Methods:
    - a `setTopSpeed` method which accepts a `double` value, updates the **topSpeed** attribute with it, and is
      accessible from other classes
    - a `getTopSpeed` method which is accessible from other classes and returns the value of the **topSpeed** attribute
    - a `setType` method which accepts a `String` value, updates the **type** attribute with it, and is accessible
      from other classes
    - a `getType` method which is accessible from other classes and returns the value of the **type** attribute
    - a `toString` method which returns a String of the information about the `Car` class of the form
      `"This Car has a topSpeed of x with the type y."` where x is the value of the **topSpeed** attribute
      and y is the value of the **type** attribute.

### Test Class:

Your `Test` class will have a main method which initializes a `Car` of **topSpeed** 220 and **type** "Ford". Then,
print the toString for this class.