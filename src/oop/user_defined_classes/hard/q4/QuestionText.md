# oop-user_defined_classes-hard-q4

## Notes

- Vary both of the attributes for this question and the class name
- Also vary the method name
- Java question

## Question Text

Have you ever lived in an apartment that has no laundry machines, so you need to walk your dirty clothes to a laundromat
down the street? Write a Java class called `Laundromat` to keep track of dirty items and let you know when they are 
clean. See the description below for the requirements.

### Laundromat Class:

Your `Laundromat` class should have the following items:

- Attributes:
    - An `int` called **gymClothes** which should not be accessible from another class

- Constructors:
    - A constructor which accepts one int and sets the **gymClothes** attribute.
    - This constructor should be visible to other classes

- Methods:
    - A method called `doLaundry` which another class can use to clean the **gymClothes** one by one. It displays a 
      message to let the user know that each item is being cleaned. When all the items have been cleaned, the method 
      displays that the laundry is done. **gymClothes** should be set to 0 afterwards. The sample output of this method 
      when there are 5 dirty **gymClothes** is shown:

      Cleaning item 1
  
      Cleaning item 2
  
      Cleaning item 3
  
      Cleaning item 4
  
      Cleaning item 5
  
      Your laundry is done!
