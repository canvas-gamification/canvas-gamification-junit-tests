# oop-special_class_method-hard-q4

## Question Text

Chemistry tells us a lot about the properties of different liquids. Write a Java class called **Detergent** that has a
`String` variable called **name** and another `String` variable called **strength**. Write a constructor 
for this class that accepts two `String` values, then sets the variable **name** and **strength** to that value. 
Also, write a **toString** method that summarizes the attributes of that object. Also, write accessor and mutator methods 
for the necessary variables.


### Detergent Class:

Your `Detergent` class must have the following items:

- Fields :
    - a `String` field named **name** which is not accessible from other classes
    - a `String` field named **strength** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts two`String` value to initialize the
      **name** and **strength** fields.

- Methods:
    - a `setName` method which accepts a `String` value, updates the **name** field with it, and is accessible from
      other classes
    - a `getName` method which is accessible from other classes and returns the value of the **name** field
    - a `setStrength` method which accepts a `String` value, updates the **strength** field with it, and is accessible
      from other classes
    - a `getStrength` method which is accessible from other classes and returns the value of the **strength** field
    - a `toString` method which returns a String of the information about the `Detergent` class of the form
      `"Detergent{name: " + name + ", strength: " + strength + "}"`.

### Test Class:

Your `Test` class will have a main method which initializes a `Detergent` of **name** "Bleach" and **strength** "High". Then,
print the toString for this class.