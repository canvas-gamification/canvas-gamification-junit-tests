# oop-programs_with_interesting_classes-easy-q5

- Parsons Question

## Question Text

Social media and the Internet have enabled people to communicate with each other across great distances. Make a Java
class called `Discord` that mimics a social media platform using the first set of requirements below. Then make another 
class to test the first using the second set of requirements below.

### Discord Class

The `Discord` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - A `String` attribute called **content**
    - A `String` attribute called **user**

- Constructors:
    - A constructor which is visible from another class. It should accept two `String` parameters, using the first value
      to initialize the **content** attribute and the second `String` to initialize the **user** attribute.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `toString` method that returns `x From: y` where x is the value of the **content** attribute and y is the value
      of the **user** attribute.
    - A `getContent` method which returns the value of **content** attribute.
    - A `getUser` method which returns the value of **user** attribute.
    - A `setContent` method, which does not return anything, and changes the value of **content** attribute to its input.
    - A `setUser` method, which does not return anything, and changes the value of **user** attribute to its input
    - A `deleteMessage` method which changes the **content** attribute to an empty string.
    - Note that all these methods should be visible from other classes
  

### TestSocialMedia class

- Main method:
    - In the main method create 2 instances of the `Discord` class. The first one should have the content `Hello there` 
      for user `Jeremy` and the second one with the content `The sky is blue` for user `Jane`. Finally, use the 
      `toString` method to print each message on a separate line.