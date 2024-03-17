# oop-programs_with_interesting_classes-easy-q5

- Parsons Question

## Question Text

Social media and the Internet has enabled people to communicate with each other through great distances. Make a Java
program that mimics a social media platform called `Discord` and another class to test it using the requirements below:

### Discord Class

The `Discord` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - A `String` attribute called **content**
    - A `String` attribute called **user**

- Constructors:
    - A constructor visible from another class that accepts two `String` as parameters, and uses the values
      to initialize the **content** and **user** attributes
    - Note that this constructor should be visible from all other classes.

- Methods:
    - An accessor and mutator methods for the **content** attribute called `getContent` and `setContent`.
    - An accessor and mutator methods for the **user** attribute called `getUser` and `setUser`.
    - A `deleteMessage` method which changes the **content** attribute to an empty string.
    - A `toString` method that returns `x From: y` where x is the value of the **content** attribute and y is the value
      of the **user** attribute.
    - A `getContent` method which returns the value of **content** attribute.
    - A `getUser` method which returns the value of **user** attribute.
    - A `setContent` method, which does not return anything, and changes the value of **content** attribute to its input.
    - A `setUser` method, which does not return anything, and changes the value of **user** attribute to its input
  

### TestSocialMedia class

- Main method:
    - In the main method create 2 `Discord` classes first one with the content `Hello there` for user `Jeremy` and the
      the second one with the content `The sky is blue` for user `Jane`. Finally user the `toString` method to print
      them in order.