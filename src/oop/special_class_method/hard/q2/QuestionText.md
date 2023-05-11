# oop-special_class_method-hard-q2

## Question Text

You are writing a Java program about objects that can grow different sizes and have different types. Write a Java class
called **Glasses** that has an attributes called **size** of type `double` and `String` variable called **type**. Write
a constructor for this class that accepts a `double` value and a `String` value, then sets the variables **size**
and **type** to those values (but for **size** set the value to the input value * 10). Also, write a **toString** method
that summarizes the attributes of that object. Also, write accessor and mutator for the necessary variables.

### Glasses Class:

Your `Glasses` class must have the following items:

- Fields :
    - a `double` field named **size** which is not accessible from other classes
    - a `String` field named **type** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a `double` and a `String` value to initialize the
      **size** and **type** fields.

- Methods:
    - a `setSize` method which accepts a `double` value, updates the **size** field with it, and is accessible from
      other classes
    - a `getSize` method which is accessible from other classes and returns the value of the **size** field
    - a `setType` method which accepts a `String` value, updates the **type** field with it, and is accessible
      from other classes
    - a `getType` method which is accessible from other classes and returns the value of the **type** field
    - a `toString` method which returns a String of the information about the `Glasses` class of the form
      `"Glasses{size: " + size +", type: " + type + "}"`.

### Test Class:

Your `Test` class will have a main method which initializes a `Glasses` of **size** 7.5 and **type** "long". Then,
print the toString for this class.