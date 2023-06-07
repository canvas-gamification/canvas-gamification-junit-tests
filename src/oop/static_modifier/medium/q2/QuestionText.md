 # oop-static_modifier-medium-q2

- Question Type: Parsons with distractors

## Question Text

Suppose you want to randomly assign a numeric identifier to various manufactured objects. Use the requirements below to 
code a `Laptop` class in Java.

### Laptop Class

Your `Laptop` class must have the following items:

- Attributes:
    - An `int` attribute called **identification** 
    - A static `int` attribute called **initial** which is used to assign new **identification** numbers
    - Note that all attributes in this class should be private

- Constructors:
    - A constructor that calls the `incrementer` method to initialize the **identification** attribute of the `Laptop`

- Methods:
    - A `getIdentification` method which returns the **identification** field and should be visible from another class
    - A `setIdentification` method which takes an `int` parameter and updates the **identification** attribute to that 
      value. It should be visible from another class
    - An `incrementer` method which increments the value of the initial by 5 and returns that value. It should be 
      visible from another class

# TestObject Class

Your `TestObject` class must have the following items:

- Main Method:
    - The main method should initialize two `Laptop` objects
    - After initializing both objects, print the `identification` value of each object, starting with the first object