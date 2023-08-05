# oop-object_interactions-medium-q3

- Java question

## Question Text

You work at a printing company and your summer job is to make copies of original works. Make a **Newspaper** class that
has attributes to store the year, month, and day of the print as well as the story.

## Newspaper Class

The `Newspaper` class currently has the following items:

- Attributes:
    - An `int` called **myYear**
    - An `int` called **myMonth**
    - An `int` called **myDay**
    - A `String` called **myStory**
    - None of these attributes should be accessible from other classes.

- Constructors:
    - A constructor with no parameters that initializes all the int attributes to -1 and the **myStory** to an
      empty `String`.
    - It is accessible from other classes.

- Methods:
    - Getter methods for the **myStory**, **myYear**, **myMonth**, and **myDay** attributes that are accessible from other
      classes.

You must add the following items to the class:

- Constructors:
    - A constructor that takes three `int` and one `String` in that order and initialized the **myYear**, **myMonth**,
      **myDay**, and **myStory** attribute in that order.
    - It should be accessible from other classes.

- Methods:
    - A `makeCopy` method that take another **Newspaper** object and change the attribute of the class to the attributes
      of the input parameter **Newspaper** object.
    - A `toString` method which returns the information about the class in the following `String` structure:
      if the **myYear**, **myMonth**, **myDay**, and **myStory** attributes are in order 2023, 6,
      9, and `It's graduation day!`. Then the `String` should be `2023/6/9:The story is: It's graduation day!`.
    - All methods must be accessible from other classes.

## TestNewspaper Class

Your `TestNewspaper` class must have the following items:

- Main Method:
    - A `main` method which initializes one **Newspaper** class with the date 2021/12/5 and the story of
      `The votes are in!` and print it using **toString** method.
    - Then initialize a new **Newspaper** object without parameters, print it, and use the `makeCopy` method to copy the previous
      object into the new one and finally print it again.