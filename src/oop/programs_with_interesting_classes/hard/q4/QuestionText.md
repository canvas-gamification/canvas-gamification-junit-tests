# oop-programs_with_interesting_classes-hard-q4

- Java Question

# Question Text

Word search puzzles are used in many classrooms to help children build their vocabulary. You are given the test class
below called `BuildVocab` that creates an object of the class called `WordSearch` with a list of 5 words
about sports. The program then displays that newly created puzzle. Your task is to complete the `WordSearch`
class in this question. More details below.

Searching for a place to live is an arduous and demanding process for most people. Below is a test class called 
`CraigsList` that defines an array of 5 rental advertisements (`Ad` objects) each with a street address, the number 
of rooms, and the cost of the monthly rental fee. The class also has a few methods that can be used to find listings 
that have a certain number of rooms (e.g., 2 rooms) or listings whose monthly fees are under a certain amount 
(e.g., $1300 per month). Your task is to complete the method definitions missing from `CraigsList`, and to define an 
`Ad` class. You will not be graded on the provided code in the main method of `CraigsList`. More details are provided 
below.

### Ad Class

Your `Ad` class must have the following requirements:

- Attributes:
    - a `String` attribute called **street**
    - an `int` attribute called **numberOfRooms**
    - a `double` attribute called **monthlyRent**
    - all of these attributes must not be accessible from another class.

- Constructor:
    - The constructor should accept a `String`, an `int` and a `double` in that order to initialize the **street**,
      **numberOfRooms** and **monthlyRent** attributes.
    - The constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class.
    - A `getMonthlyRent` method which returns the **monthlyRent** attribute.
    - A `getNumberOfRooms` method which returns the **numberOfRooms** attribute.
    - A `toString` method which returns a `String` in the form of 
      ```
            "Address: x
            Number of rooms: y
            Monthly rent: z
            "
      ```
      where x is the value of **street**, y is the value of **numberOfRooms**, and z is the value of **monthlyRent**.

## CraigsList Class

### Methods

#### Print Ad List

- A method that is **static** and accessible to other classes called `printAdList`.
- This method must accept an `Ad[]` as a parameter and return nothing.
- The method should iterate through the array and for each `Ad` print its position in the list, starting at 1 not 0, 
  and then print its information using the `Ad` class's `toString` method. Finally, print an extra empty line after
  the `Ad` to visually split the different entries.
```
Sample output:
Ad 1:
Address: 123 Main St
Number of rooms: 2
Monthly rent: 900.0

Ad 2:
...
```

#### Filtered By Rooms

- A method that is **static** and accessible to other classes called `filteredByRooms`.
- This method must accept an `int` and an `Ad[]` as parameters in that order and return a newly created `Ad[]`.
- This method should search the given array for `Ad` object where the **numberOfRooms** attribute matches the passed
  integer. It should then add them to a new array and return that new array.
- Note: the returned array should have no empty indexes.

#### Filtered By Max Rent

- A method that is **static** and accessible to other classes called `filteredByMaxRent`.
- This method must accept a `double` and an `Ad[]` as parameters in that order and return a newly created `Ad[]`.
- This method should search the given array for `Ad` object where the **monthlyRent** attribute is less than or equal
  to the passed double. It should then add them to a new array and return that new array.
- Note: the returned array should have no empty indexes.
