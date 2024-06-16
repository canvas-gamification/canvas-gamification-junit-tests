# oop-programs_with_interesting_classes-easy-q6

- Parsons Question

## Question Text

University courses are expensive. Beyond tuition, there are also necessary supply costs, textbooks, and lab equipment.
Make a class called `Course` to keep track of where the costs are coming from using the requirements below.
Then make a class called `SemesterCost` to test the `Course` class.

### Course Class

The `Course` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - A `double` attribute called **textbookFee**
    - A `double` attribute called **suppliesFee**
    - A `double` attribute called **labFee**

- Constructors:
    - A constructor visible from another class that accepts three `double` as parameters, and uses the values
      to initialize the **textbookFee**, **suppliesFee**, and **labFee** attributes in that order.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `calcTotalCost` method which returns the sum of the three attributes and should be visible to other classes.

### SemesterCost class

- Main method:
    - In the main method initialize 5 `Course` objects and then calculate the total cost for each course using the
      `calcTotalCost` method. Sum the total cost for all the courses and then print the semester's cost.