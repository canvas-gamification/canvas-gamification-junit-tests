# oop-object_interactions-medium-q1

- Java question

## Question Text

Suppose you wanted two vehicles to split the load they had to carry so that the overall weight is more evenly
distributed. Using the provided Truck class, add a method to it so that the weight can be split, and create a test class
to test your method using the requirements below.

## Truck Class

The `Truck` class currently has the following items:

- Attributes:
    - `private double currentWeight`

- Constructors:
    - a `public Truck(double w)` constructor which initializes the weight attribute of the truck

- Methods:
    - A `public void setCurrentWeight(double w)` method that sets the `weight` attribute of the truck to the passed
      value
    - A `public double getCurrentWeight()` method that gets the `weight` attribute of the truck
    - A `public String toString()` method which returns the string "My weight is: x" where x is the `weight` attribute
      of the truck

You must add the following items to the class:

- Methods:
    - A `splitLoad` method to split the combined weight of two `Truck` objects evenly across them. It must accept a
      `Truck` object as a parameter, and then evenly split the total weight of the passed truck and the truck the method
      was called on. Also, this method must be visible from another class, and it should not return anything.

## TestTruck Class

Your `TestTruck` class must have the following items:

- Main Method:
    - A `main` method which initializes two `Truck` objects, one with a `weight` value of 450.8 and the other with a
      value of 0.
    - Then, print out the weights of the two Trucks using the provided `toString` method, starting with the heavier
      `Truck` first. See the sample output below for how to structure this.
    - Next, call the `splitLoad` method you created on one of the `Truck` objects, passing in the other `Truck` as a
      parameter
    - Finally, print the weights of the `Truck` objects again using the `toString` method.
    - The sample output is as follows. Note that the "Before Split: " and "After Split: " statements are required
      ```
        Before split: 
           My weight is: 450.8
           My weight is: 0.0
        After split:
           My weight is: 225.4
           My weight is: 225.4
