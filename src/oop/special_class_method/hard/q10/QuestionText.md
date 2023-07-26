# oop-special_class_method-hard-q10

## Question Text

You've been chosen to make plans for an award show! Your first task is to model the awards being received, so create a
java class called **Award** that has two `String` attributes **awardRecipient** and **awardCategory** that are
initialized by the constructor. You will need to compose the necessary methods so that these attributes can be accessed
and modified from outside the class.

### Award Class:

Your `Award` class must have the following items:

- Attributes:
    - A `String` attribute named **awardRecipient** which is not accessible from other classes
    - A `String` attribute named **awardCategory** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts two `String` parameter to initialize the
      **awardRecipient** and **awardCategory** attributes in that order.

- Methods:
    - a `setAwardRecipient` method which accepts a `String` value, updates the **awardRecipient** attribute with it, and
      is accessible from other classes
    - a `getAwardRecipient` method which is accessible from other classes and returns the value of the
      **awardRecipient** attribute
    - a `setAwardCategory` method which accepts a `String` value, updates the **awardCategory** attribute with it, and
      is accessible from other classes
    - a `getAwardCategory` method which is accessible from other classes and returns the value of the **awardCategory**
      attribute
    - a `toString` method which returns a String of the information about the `Award` class of the form
      `"The award for x category goes to y"`. where x is the value of **awardCategory** attribute and y
      is the value of **awardRecipient** attribute

### Distractors:
- return AwardCategory;
- return awardCategory = awardCategory;
- public String awardCategory;
- public String awardRecipient;
- private class Award
- public Award()
- public void setAwardRecipient(String)	
- awardCategory = awardCategory;
- awardRecipient = awardRecipient;