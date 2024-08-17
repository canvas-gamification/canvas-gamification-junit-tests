# oop-programs_with_interesting_classes-hard-q1

- Java Question

## Question Text

Lots of organizations have their employees do work in teams. When people don't know each other, we often put them into 
teams randomly. Below is a test class called `TeamFormation` that shows an example of 6 `Person`s who are split 
into two `Team`s and displays the members of those teams and the average skill level. Your task is to complete the 
`Person` and `Team` classes in this question. The resulting classes should work with the test class given below, 
regardless of the details of how `assignRandomly()` is implemented. More explanation below.


### Person Class

Your `Person` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - an `int` attribute called **programming** which represents their programming skill
    - an `int` attribute called **communication** which represents their communication skill
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` and two `int` values to initialize the **name**, **programming**, and
      **communication** attributes in that order.
    - The constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class.
    - A `getName` method which returns the **name** attribute.
    - A `getProgramming` method which returns the **programming** attribute.
    - A `getCommunication` method which returns the **communication** attribute.
    - A `toString` method which returns a `String` in the form of "x: y, z\n" where x is the value of **name**, y is the 
      value of **programming**, and z is the value of **communication**.

## Team Class

### Attributes

- A `Person[]` attribute called **members**
- An `int` attribute called **index**
- all of these attributes must not be accessible from another class

### Constructor

- The constructor must be visible from another class.
- It should accept an `int` value and use it to initialize the size of the **members** array.
- The constructor should initialize **index** to `0`.

### Methods

#### Add Member

- A method that returns a boolean and is accessible to other classes called `addMember`.
- This method must accept a `Person` as a parameter.
- It should check that the **members** array is not full (You can compare the **index** value against the length of
  the array). If there is space, add the `Person` at the **index** and then increase the value of **index** and return
  `true`. Otherwise, change nothing and return `false`.

#### Get Index
- A method that returns the **index** attribute and is accessible to other classes called `getIndex`.

#### Get Average Skills

- A method that returns a `String` and is accessible from other classes called `getAverageSkills`.
- This method should calculate the average **programming** skill and **communication** skill across the entire team as
  a `double` value. It should not include empty slots in the team as part of the average calculation. It should also be 
  able to handle requests to get the average with no **members** added.
- The returned `String` should follow this format:
```
Team's average skill level is:
    Programming:   1.6666666666666667
    Communication: 3.0
  ```
- Hint: ```\t``` represents a tab in a `String` and both skills have a linebreak after them in the `String`.

#### To String

- A `toString` method which returns a `String` of the `Team` **members** using the `Person` `toString` method. The list
  should have a space preceding it, between each `Person`, and following it.
```
Sample output:
 Phil: 3, 2
 Alex: 5, 1
 
```
