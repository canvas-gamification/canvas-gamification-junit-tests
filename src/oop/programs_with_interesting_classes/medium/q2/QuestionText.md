# oop-programs_with_interesting_classes-medium-q1

- Parsons Question

## Question Text
Google Maps has software that determines distances between different cities. Using the requirements below, create a `Map`
and `TestMap` class to model the different routes.

### Map Class

Your `Map` class must have the following requirements:

- Attributes:
    - a *static* `int[][]` attribute called **connections** which is initialized to represent the distances between the 
      cities of Milan, Venice, London, Stockholm, and Berlin. Assume the cities are defined in this order such that Milan 
      is at index 0 of the arrays, Venice at 1, etc. and the values in row 0 column 1 represents the distance to travel 
      from Milan to Venice. The values on the diagonal should all be 0 since there is no travel distance between the city 
      itself. If there are no direct routes connecting the two cities, then the value in the array will be -1.

- Methods:
    - A `calculateDistance` method which accepts two `int`s as array indices for **connections** and returns the 
      corresponding distance as an `int`. If a direct route does not exist (if the distance is equal to -1), then the 
      distance is the cumulative distance of the first two connecting roads in the array.

### TestMap Class

Your `TestMap` Class must have the following:

- Main method:
    - A `main` method to run the class from.
    - It must set up a Scanner to read the names of two cities and store them in two `String` variables.
    - Then, convert the city names into integers using the `convertStringToIndex` method and calculate the distance
      between them using the `Map` class.
    - Finally, print the returned distance.

- convertStringToIndex method:
    - A *static* method called `convertStringToIndex` which is accessible from any class, accepts a `String` as a 
      parameter and returns an `int`.
    - The method should use a switch statement to convert a city to its appropriate index.
    - If the provided `String` is not a valid city it should return -1.
