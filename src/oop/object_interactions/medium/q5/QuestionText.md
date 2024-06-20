# oop-object_interactions-medium-q5

- Java question

## Question Text

You always need to keep track of transplants in a hospital. To do so, make a **Person** class using the following
descriptions to keep track of eye transplants with methods to transplant eyes to another **Person** object.

## Person Class

The `Person` class currently has the following items:

- Attributes:
    - A `String` called **myName**
    - An `int` called **numEyes**
    - None of these attributes are accessible from other classes.

- Constructors:
    - A constructor that takes a `String` and an `int` to initialize the **myName** and **numEyes** attributes.
    - It is accessible from other classes.

- Methods:
    - Getter and Setter methods for **myName** and **numEyes** attributes
    - These methods are accessible from other classes.

You must add the following items to the class:

- Methods:
    - A `receiveDonation` method that takes another **Person** object called **donor** to do a transplant and gives an 
      eye to the object calling the method. It should check if the **numEyes** in the donor is more than zero. If the 
      donor has enough eyes take 1 unit of **numEyes** from donor and give it to the **Person**, and then print 
      `Transplant successful`. If not, it should print `Transplant cannot be done`. This method must not return any value.
    - A `toString` method that returns the `String` of information in the format of `x has y eyes"` where x is the 
      value of **myName** and y is the value of **numEyes**.

## TestTransplant Class

Your `TestTransplant` class must have the following items:

- Main Method:
    - A `main` method that initializes two **Person** objects named Tom and Jim, where Tom has 2 eyes and Jim has zero,
      and prints them using **toString()**. Print Tom's information first and Jim's second. Then have Jim receive a
      transplant from Tom.
    - Print the information of Tom and then Jim using **toString()**.
      - Make sure to print every message on a separate line.