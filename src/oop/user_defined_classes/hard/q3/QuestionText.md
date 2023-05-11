# oop-user_defined_classes-hard-q1

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name
- Java question

## Question Text

Your kitchen has a lot of supplies, and it is time to clean up! Write a Java class called `Cupboard` to keep track of 
your supplies. See the description below for the requirements.

### Cupboard Class:

Your `Cupboard` class should have the following items:

- Attributes:
    - An `int` called **pots**
    - A `boolean` called **anyClean**

- Constructors:
    - A default constructor which sets the **pots** field to be 0 and the **anyClean** field to be false.

- Methods:
    - A method called `washComplete` which takes as input the number of pots that are clean and are ready to be put back 
      inside the cupboard. This value will be added to **pots** and the boolean variable will be set to **true** if the 
      number of pots is therefore greater than 0.