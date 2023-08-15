# oop-user_defined_classes-hard-q7

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name
- Java question

## Question Text

There are many ways that a teacher can assess the material of a course. Write a Java class called `Course` that keeps 
track of course metrics. See the description below for the requirements.

### Course Class:

Your `Course` class should have the following items:

- Attributes:
    - A `String` called **topic** which should not be accessible from another class
    - An `int` called **difficulty** which should not be accessible from another class

- Constructors:
    - A constructor which accepts a String and an int and sets the **topic** and **difficulty** attributes. The first 
      attribute should set **topic** and the second should set **difficulty**.
    - This constructor should be visible to other classes

- Methods:
    - A method called `determineDifficulty` which another class can give an integer representing the difficulty and 
      determines whether the course is considered difficult. If the given number is greater than or equal to 
      **difficulty** then print "**topic** is a difficult course" otherwise print "**topic** is not a difficult course".
