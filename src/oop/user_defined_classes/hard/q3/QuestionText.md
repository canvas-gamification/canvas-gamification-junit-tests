# oop-user_defined_classes-hard-q3

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name
- Also vary the starting values of the attributes
- Java question

## Question Text

Your kitchen has a lot of supplies, and it is time to clean up! Write a Java class called `Cupboard` to keep track of 
your supplies. See the description below for the requirements.

### Cupboard Class:

Your `Cupboard` class should have the following items:

- Attributes:
    - An `int` called **pots** which should not be accessible from another class
    - A `boolean` called **anyClean** which should not be accessible from another class

- Constructors:
    - A constructor which sets the **pots** attribute to be 0 and the **anyClean** attribute to be false.
    - A constructor which accepts an `int` and a `boolean` from another class and uses the `int` to set the **pots** 
      attribute and the `boolean` to set the **anyClean** attribute.
    - Both constructors should be visible to other classes

- Methods:
    - A method called `washComplete` which is visible to other classes and takes as input the number of pots that are 
      clean and are ready to be put back inside the cupboard. This value will be added to **pots** and the boolean 
      variable will be set to **true** if the number of pots is greater than zero. This method returns nothing.
  