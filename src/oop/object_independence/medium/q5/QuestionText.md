# oop-object_independence-medium-q5

## Question Info

- Question type: Java

### Question Text

Your friends are interested in betting on which team wins the Stanley Cup this year. Make a program called **Team** 
where you keep track of the teams in the league and the games they have won as attribute using the description below.

### Team Class

Your `Team` class must have the following items:

- Attributes:
    - A `String` called **name**
    - An `int` called **totalWins**
    - Note that neither of these attributes should be visible from another class

- Constructors:
    - A single constructor with parameters of a `String` and an `int` that initializes the **name** and
      **totalWins** attributes
    - This constructor should be visible from another class

- Methods:
    - a `getTotalWins` method which is accessible from other classes and returns the **totalWins** attribute
    - a `setTotalWins` method which accepts an `int` value, updates the **totalWins** attribute with it,
      and is accessible from other classes
    - a `toString` method which returns a String of the information about the `Team` class of the form
      `"Team x has won y games"`, where x is the value of **name** and y is the value of **totalWins**,
      and is visible from other classes.
    - Note that all setter methods must not return any value