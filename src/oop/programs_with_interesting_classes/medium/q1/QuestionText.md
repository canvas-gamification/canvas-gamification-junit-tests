# oop-programs_with_interesting_classes-medium-q1

- Parsons Question

## Question Text

The vehicle show is in town, and they are having a high-octane vehicle-on-vehicle action showcase every night! Using the
requirements below, create a `Car` and `Collision` class to model each car and a collision between them.

### Car Class

Your `Car` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - a `double` attribute called **speed**
    - a `String[]` attribute called **parts**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` and a `double` in that order to initialize the **name** and **speed**
      fields.
    - It should also initialize the **parts** attribute to an array of length seven with following parts: **Wheels**,
      **Chassis**, **Steering**, **BodyKit**, **Windows**, **Doors**, and **Seats**. Make sure the order is exactly as
      listed.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `setParts` method which accepts a `String[]` and updates the **parts** attribute to that value.
    - A `getParts` method which returns the **parts** attribute
    - A `setSpeed` method which accepts a `double` and updates the **speed** attribute to that value
    - A `getSpeed` method which returns the value of the **speed** attribute
    - A `setName` method which accepts a `String` and update the **name** attribute to that value
    - A `getName` method which returns the value of the **name** attribute
    - A `toString` method that returns a String of the form "Car{name='x', speed=y, parts=[a, b, c, ... , z]}" where x
      is the value of the **name** attribute, y is the value of the **speed** and a, b, ..., z are all the strings in
      the **parts** array (Hint: the `Arrays.toString()` method can be used to return all the values in the parts
      array).

### Collision Class

Your `Collision` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize two `Car` objects. One should be named `"Volkswagen Golf"` and have a speed of `60.0`. The
      other must be named `"Mini Cooper"` and have a speed of `65.6`.
    - Then, call and print the result of the `toString` method of both cars on separate lines, with
      the `"Volkswagen Golf"` being printed first.
    - After, call the `collide` method on the cars.
    - Finally, print the result of the `toString` of each of the cars again, in the same format and order as the first
      time.

- Collide method:
    - A method called `collide` which is accessible from any class, is *static*, returns nothing, and accepts two `Car`
      objects as parameters.
    - The method should compare the **speed** attributes of both cars to check which one is going slower.
    - On the slower car, it should remove the last two strings from the **parts** array. To do this, create a new array
      where the length is two less than the old **parts** array, and copy in all the strings except the last two.
      Then, update the value of **parts** to this newly created array.
    - If both cars are going the same speed, remove two parts from both.
