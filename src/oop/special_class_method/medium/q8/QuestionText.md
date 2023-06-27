# oop-special_class_method-medium-q7

## Question Text

You want to make a battle game with characters that are modeled after the characters from the well-known anime called 
One Piece who ate the devil fruit to gain a special ability. Make a Java class called **Luffy** that has  
attributes called  **skill** and **bounty**. This class has the basic constructor that initializes the attributes, 
accessors and mutators for each attribute, and a **toString()** method that returns the total amount of money available 
as a String.


### Luffy Class:

Your `Luffy` class must have the following items

- Attributes:
    - An `String` called **skill**
    - An `int` called **bounty**

- Constructor:
    - a `Luffy` constructor that is visible to other classes and accepts a `String` and an `int` and uses it to initialize the
      **skill** and **bounty** fields.

You need to add the following items:

- Methods:
    - a `setSkill` method which accepts a `String` and uses it to set the value of the **skill** field
    - a `getSkill` method which returns the value stored in the **skill** field
    - a `setBounty` method which accepts an `int` and uses it to set the value of the **bounty** field
    - a `getBounty` method which returns the value stored in the **bounty** field
    - a `toString` method which returns the string `"My special skill is " + skill + " and my bounty is " + bounty`.