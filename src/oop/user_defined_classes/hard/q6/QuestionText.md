# oop-user_defined_classes-hard-q6

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name
- Java question

## Question Text

Life is busy and there's always lots of work to do! Write a Java class called `UniversityStudent` to keep track of and
complete work. See the description below for the requirements.

### UniversityStudent Class:

Your `UniversityStudent` class should have the following items:

- Attributes:
    - An `int` called **fatigueLevel** which should not be accessible from another class
    - An `int` called **workload** which should not be accessible from another class

- Constructors:
    - A constructor which accepts two ints and sets the **fatigueLevel** and **workload** attributes. The first int 
      should set **fatigueLevel** attribute and the second the **workload** attribute.
    - This constructor should be visible to other classes

- Methods:
    - A method called `workAllDay` which completes the workload by decrementing **workload** until it hits 0, but also 
      increases the fatigue level for every piece of work completed. The method should print "Fatigue level is 
      **fatigueLevel**" once all work is completed. It should not return anything. 