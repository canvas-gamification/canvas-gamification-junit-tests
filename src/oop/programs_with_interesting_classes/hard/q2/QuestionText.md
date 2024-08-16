# oop-programs_with_interesting_classes-hard-q2

# Question Text

Games typically keep track of scores and show players their ranking in a leaderboard at the end of a game. You are given 
the test class below called `CandyCrush` tha creates objects of the `Player` class and adds them to a `LeaderBoard`. 
Each `Player` gets a score and the top two players in the game. Your task is to complete the `Player` and `LeaderBoard`
classes in this question. More details below.

## Player Class

- Attributes:
  - a `String` attribute called **name** 
  - an `int` attribute called **score**
  - all of these attributes must not be accessible from another class

- Constructor:
  - The constructor must be visible from another class.
  - The constructor should accept a `String` to initialize the **name** attribute and initialize the **score** attribute
    to `0`.

- Methods:
  - All the following methods should be visible from another class, and if there is no return type specified, assume
    it should return nothing.
  - A `getName` method which returns the **name** attribute
  - A `getScore` method which returns the **score** attribute.
  - A `setScore` method which accepts an `int` and change the value of **score** to that `int`.
  - A `toString` method which returns a `String` in the form of "x: y points" where x is the value of **name** and y is 
    the value of **score** attribute.

## LeaderBoard Class

### Attributes

- A `Player[]` attribute called **players**
- An `int` attribute called **numPlayers**
- all of these attributes must not be accessible from another class

### Constructor

- The constructor must be visible from another class.
- This constructor must accept an array of `Player`s to be added to the **players** attribute.
- The **numPlayers** attribute should initially be set to 0 and the **players** attribute initialized to an empty array
  with a length of `100`.
- The constructor should check that the input array's length is less than or equal to the length of the **players** 
  array. If so, using the input array, the constructor should iterate over the array and add each `Player` to the 
  **players** array using the `addPlayer` method. Otherwise, the array should remain empty.

### Methods

#### Add Players

- A method that returns a `boolean` and is accessible to other classes called `addPlayers`.
- This method must accept a `Player` as a parameter.
- The method places the `Player` in the first available spot in the **players** attribute.
- Before placing the `Player`, the method should check to see if the **numPlayers** currently in the array is less than
  the length of the array. If so, it should place the `Player`, increment the value of **numPlayers** and return true.
  Otherwise, it should return false.

#### Get Top 2

- A method that returns a `String` and is accessible from other classes called `getTop2`
- This method iterates through the **players** array and finds the two `Player` objects with the highest **score**s.
- It must then return a `String` of this information on two separate lines. 
```
Sample output if printed:
Winner: Sandra with 27 points
Runner-up: Margaux with 25 points
```
- Where there are not enough objects in **players** to fill both the winner and runner-up, the 
empty positions should fill the name with `"empty"` and points with `-1`.
- Note: the line break after the runner-up should be included in the `String`