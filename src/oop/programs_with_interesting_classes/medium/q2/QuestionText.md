# oop-programs_with_interesting_classes-medium-q1

- Parsons Question

## Question Text
Google Maps has software that determines distances between different cities. Using the requirements below, create a `Map`
and `TestMap` class to model the distances.

### Map Class

Your `Map` class must have the following requirements:

- Attributes:
    - an `int[][]` attribute called **connections** which is initialized to represent the distances between Milan, Venice,
      London, Stockholm, and Berlin. Assume the cities are defined in this order such that Milan is at index 0, Venice at 
      1, etc. and the values in row 0 column 1 represents the distance to travel from Milan to Venice. The values on the 
      diagonal should all be 0 since there is no travel. If there are no direct routes connecting the two cities, then 
      the value in the array will be -1.
    - **connections** must not be accessible from another class.

- Methods:
    - A `calculateDistance` method which accepts two `int`s as array indices for **connections**. If a direct route does 
      not exist (if the distance is equal to -1), then the distance is the cumulative distance of the two connecting roads. 
      The method should return the distance as an `int`.
    - The `calculateDistance` method should be visible from another class, and return an `int`.

### TestMap Class

Your `TestMap` Class must have the following:

- Main method:
    - A `main` method to run the class from.
    - It must define 5 ints


The program also has a test class called <tt>TestMap</tt> that defines each city as an array index and then calls <tt>calculateDistance()</tt> from London to Venice and displays that as output.
