# oop-user_defined_classes-hard-q5

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name
- Java question

## Question Text

The way stores calculate screen sizes are kind of confusing. Write a Java class called `Phone` to compute the 
diagonal of the screen. See the description below for the requirements.

### Phone Class:

Your `Phone` class should have the following items:

- Attributes:
    - An `double` called **width** which should not be accessible from another class
    - An `double` called **height** which should not be accessible from another class

- Constructors:
    - A constructor which accepts two doubles from another class and sets the **width** and **height** attributes. The 
      first double should set **width** attribute and the second the **height** attribute.
    - This constructor should be visible to other classes

- Methods:
    - A method called `calcScreenSize` which another class can use to compute the diagonal of the screen using the 
      Pythagorean Theorem.
