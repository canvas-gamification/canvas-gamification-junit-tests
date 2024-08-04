# oop-programs_with_interesting_classes-medium-q10

- Parsons Question

## Question Text

Stores need to keep track of their inventory so they can restock before the items are sold out. Make a Java program 
called `Cashier` to model the employees, and a program called `TestShopping` to model interactions with customers.

### Cashier Class

Your `Cashier` class must have the following requirements:

- Attributes:
    - a *static* `String` attribute called **items** that stores the names of the items the store sells
    - a *static* `int` attribute called **stock** that tracks the number of items in the inventory
    - a *final* `int` attribute called **RAMEN_INDEX**
    - a *final* `int` attribute called **CHOCO_INDEX**
    - a *final* `int` attribute called **COKE_INDEX**
    - all of these attributes must not be accessible from another class
    - The *final* attributes ensure the two arrays always keep track of items in the same indices

- Constructor:
    - The first constructor should accept three `int` values to initialize the **RAMEN_INDEX**, **CHOCO_INDEX**, and
      **COKE_INDEX** attributes. It should also initialize the **items** attribute to `"Ramen", "Chocolate", "Coke"`.
    - The second constructor should be used when **stock** has already been initialized by another `Cashier` object.
      Therefore, it should only initialize the **items** attribute to `"Ramen", "Chocolate", "Coke"`.
    - These constructors should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class unless otherwise stated and return nothing.
    - A `scanItem` method which accepts a `String` and an `int` which represent the item name and purchase amount. Check
      if the `String` matches any of the value in items subtract the `int` value from the appropriate **stock** index.
      Finally, call the `checkInventory`.
    - A `checkInventory` method which is *private* and prints an alert if any of the **stock** values are `5` or below.
    - A `restock` method which checks which stock values are `5` or below and increases them by `20` and prints a message
      that the item has been restocked.

### TestShopping Class

Your `TestShopping` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize a `Cashier` object with the values of `50`, `45`, and `60`.
    - Then, call the `scanItem` method twice. First with parameters of `"Ramen"` and `30`, and second with `"Coke"` and
      `36`.
    - After, initialize another `Cashier` object using the default constructor and call the `scanItem` method twice again.
      The first time with the parameters of `"Chocolate"` and `26`, and the second time with `"Coke"` and `21`.
    - Finally, call the `restock` method.
