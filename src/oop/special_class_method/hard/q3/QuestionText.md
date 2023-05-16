# oop-special_class_method-hard-q3

## Question Text

You are writing a Java program that models household furniture and objects. Write a Java class called **Chair** that has 
a `double` variable called **size** and a `String` variable called **softness**. Write a constructor for this class 
that accepts a `double` value and a `String` value, then sets the variables **size** and **softness** to 
those values (but for **size** set the value to the input value). Also, write a **toString** method that summarizes the 
attributes of the object. Also, write accessor and mutator methods for the necessary variables.

### Chair Class:

Your `Chair` class must have the following items:

- Fields :
    - a `double` field named **size** which is not accessible from other classes
    - a `String` field named **softness** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a `double` and a `String` value to initialize the
      **size** and **softness** fields.

- Methods:
    - a `setSize` method which accepts a `double` value, updates the **size** field with it, and is accessible from
      other classes
    - a `getSize` method which is accessible from other classes and returns the value of the **size** field
    - a `setSoftness` method which accepts a `String` value, updates the **softness** field with it, and is accessible
      from other classes
    - a `getSoftness` method which is accessible from other classes and returns the value of the **softness** field
    - a `toString` method which returns a String of the information about the `Chair` class of the form
      `"Chair{size: " + size + ", softness: " + softness + "}"`.

### Test Class:

Your `Test` class will have a main method which initializes a `Chair` of **size** 10.2 and **softness** "Soft". Then,
print the toString for this class.