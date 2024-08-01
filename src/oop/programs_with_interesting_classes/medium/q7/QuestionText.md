# oop-programs_with_interesting_classes-medium-q7

- Parsons Question

## Question Text

Vending machines can have all sorts of items in them, not just candy bars and soda. An entrepreneur has built a lunch
vending machine in downtown Kelowna. Make a Java class called `HotSoup`, a class called `VendingMachine`, and a class
called `LunchRush` to test them using the requirements below.

### HotSoup Class

Your `HotSoup` class must have the following requirements:

- Attributes:
    - a `double` attribute called **price**
    - a `String` attribute called **flavour**

- Constructor:
    - The constructor should accept a `double` and a `String` in that order to initialize the **price** and **flavour**
      attributes.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class.
    - A `getPrice` method which returns the **price** attribute.
    - A `getFlavour` method which returns the **flavour** attribute.
    - A `toString` method which returns a `String` in the format of "x soup for $y" where x is the value of the **flavour**
      attribute and y is the value of the **price** attribute.

### VendingMachine Class

Your `VendingMachine` class must have the following requirements:

- Attributes:
    - a **final** `int` attribute called **CAPACITY** set to 50
    - a `HotSoup[]` attribute called **items**
    - an `int` attribute called **numAvailable**
    - all of these attributes must not be accessible from another class

- Constructor:
  - The constructor should accept no parameters and initialize the **numAvailable** attribute to the value of **CAPACITY**
    and add **CAPACITY** number of `HotSoup` objects to **items** with a price of `2.50` and a flavour of `Chicken Noodle`.
  - This constructor should be accessible from another class.

- Methods:
  - All the following methods should be visible from another class, and if there is no return type specified, assume
    it should return nothing.
  - A `buyItem` method which accepts a `double` and prints out a response statement. It should check if the machine is
    empty, if it is print a statement saying so. If it is not empty, check if enough payment was input for the next
    item. If so, remove the next item in the stock and reduce the **numAvailable** value by one and calculate the required
    change using the `getChange` method. If there is not enough money, print a statement saying so.
  - A `getChange` method which accepts an `int` representing the number of cents and returns a `String` listing the 
    breakdown of the input value into coins. The method should list how many quarters (25 cents), dimes (10 cents), 
    nickels (5 cents), and pennies (1 cent) compose the change. Note that order matters in this calculation because if 
    you try to return as many nickels as possible, you would never have to return any quarters or dimes. So be sure to 
    calculate quarters first, then dimes, then nickels, and then pennies.

### LunchRush Class

Your `LunchRush` Class must have the following methods:

- Main method:
  - A `main` method to run the class from.
  - It must initialize one `VendingMachine` object.
  - Then, as the lunch rush begins, call the `buyItem` method five times in the following order: 5.50, 3.10, 10.00, 2.55,
    and 2.66.
  - Finally, print "Lunch Rush over"
