# oop-static_modifier-hard-q1

- Question Type: Java question

## Question Text

You are working as a painter for your summer job. You bought some paint with your personal savings, and now you need to
paint some fences with that paint supply; however, painting each fence takes some of this supply. Using the requirements
below, write a `Fence` and `TestPainting` class to model this problem.

## Fence Class

Your `Fence` class must have the following requirements:

- Attributes:
    - Note that all attributes should not be visible from another class
    - A _static_ `String[]` called **colours** which is initialized to length eight and has strings "Red", "Blue",
      "Green", "Yellow", "Black", "White", "Purple", and "Brown". These represent the potential colours of the fence,
      and should be set without having to call the constructor. The colours must be in the order specified above.
    - A _static_ `double[]` called **leftoverAmount** which is initialized to length eight and each item in the array
      should have a starting value of 100.0. These values should be set without having to call the constructor.
    - A `String` called **colour** that represents the colour of hts current `Fence` object

- Constructors:
    - A constructor that is accessible from other methods, and accepts a `String` as a parameter to set the **colour**
      attribute of the object. Before setting the colour attribute, it must check that the passed colour is in the is
      also one of the strings in the **colours** array. Note that this must be an exact match (case-sensitive), and if
      no match is found, initialize the **colour** attribute to "Blue".

- Methods:
    - Note that all methods in this class should be visible from another class
    - A `paintColour` method to change the colour of the Fence with the requirements below:
        - It accepts two parameters, a `String` called **colourName** and a `double` called **neededVolume**.
        - The method checks if the passed **colourName** matches any of the colours in the **colours** array.
        - If there is a match, check the value in the **leftoverAmount** array corresponding to the same index as the
          matching colour, and see if the amount is greater than or equal to the **neededVolume** parameter.
        - If there is enough paint, then subtract **neededVolume** from the value in **leftoverAmount**, and update the
          value of the **attribute** to **colourName**. If not, print out the string "There is not enough x paint for
          this job.", where x is the value of **colourName**.
        - If the input **colourName** did not match any of the colours in the **colours** array, print out the string
          "The input colour does not match any of the paint colours."
        - This method should not return anything.
    - A `toString` method which returns the `String` "My paint colour is y.", where y is the value of the **colour**
      attribute of the `Fence` object

## TestPainting Class

Your `TestPainting` class must have the following items:

- Main method:
    - A `main` method which initializes three `Fence` objects. The first should be coloured "Red", the second "Green",
      and the third should be "Yellow". Then, call the `paintColour` method on each of the fences to paint each fence
      brown. Each fence takes a different amount of paint. The first takes 25.5, the second 68.8, and the third 38.5.
      After each call to the paint colour method, print the colour of the fence object.
    - Expected Output:
       ```
        My paint colour is Brown.
        My paint colour is Brown.
        There is not enough Brown paint for this job.
        My paint colour is Yellow.
      ```
