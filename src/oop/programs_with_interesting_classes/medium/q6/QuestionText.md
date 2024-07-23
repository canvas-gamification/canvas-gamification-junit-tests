# oop-programs_with_interesting_classes-medium-q6

- Parsons Question

## Question Text

You are participating in a horse race at a racetrack show. Make a Java class called `Horse` to model the animals racing
and a `RaceTrack` class to test them.

### Horse Class

Your `Horse` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - a `double` attribute called **gateSpeed** representing km/h
    - a `double` attribute called **acceleration** representing km/h
    - a `double` attribute called **topSpeed** representing km/h
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` and three `double` values in that order to initialize the **name**, 
      **gateSpeed**, **acceleration**, and **topSpeed** attributes.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `getName` method which returns the value of the **name** attribute
    - A `getGateSpeed` method which returns the value of the **gateSpeed** attribute
    - A `getAcceleration` method which returns the value of the **acceleration** attribute
    - A `getTopSpeed` method which returns the value of the **topSpeed** attribute
    - A `toString` method which returns a String of the form "Racer: w, starting speed of x acceleration of y and top 
      speed of z" where w is the value of the **name** attribute, x is the value of the **gateSpeed** attribute, y is the
      value of the **acceleration** attribute, and z is the value of the **topSpeed** attribute.
    - A `completionTime` method accepts a `double` value that is the distance of the race in kilometers, and returns a
      double that represents the time it takes the `Horse` to traverse this distance in minutes. The `Horse` begins the
      race at the **gateSpeed** value and each minute increase their speed by an amount equal to the **acceleration**
      value up to the value of **topSpeed**. Given that races can be photo finish, the method should remove the time
      a `Horse` overran the finish line from its total time.

### RaceTrack Class

Your `RaceTrack` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize two `Horse` objects. One should be named `"Betsy"`, have a gate speed of `38.2`, an acceleration
      of `5.1` and a top speed of `55.0`. The other must be named `"Gerald"`, have a gate speed of `34.7`, an
      acceleration of `4.3` and a top speed of `63.0`.
    - Then, announce the start of the race.
    - Finally, call and print the `completionTime` method on both `Horse` objects and compare their time to determine the 
      winner then print the result of the race.
