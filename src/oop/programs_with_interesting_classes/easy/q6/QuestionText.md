# oop-programs_with_interesting_classes-easy-q6

- Parsons Question

## Question Text

University courses can get expensive because they often come with supply costs for things like textbooks and lab
equipment. Make a class called `Course` with three attributes called **textBookFee**, **suppliesFee**, and **labFee**

### Course Class

The `Course` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - A `double` attribute called **textBookFee**
    - A `double` attribute called **suppliesFee**
    - A `double` attribute called **labFee**

- Constructors:
    - A constructor visible from another class that accepts three `double` as parameters, and uses the values
      to initialize the **textBookFee**, **suppliesFee**, and **labFee** attributes in that order.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `calcTotalCost` method which returns the sum of the three attributes.

### TestSocialMedia class

- Main method:
    - In the main method initalize 5 course classes and the calculate the total cost for each course using the
      `calcTotalCost` and sum it for all of the courses and the print the total cost of all the courses.