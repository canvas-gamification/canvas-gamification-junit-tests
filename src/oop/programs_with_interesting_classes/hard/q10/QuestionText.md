# oop-programs_with_interesting_classes-hard-q1

- Java question

# Question Text

Let us suppose you work as an assistant manager for a store, and it is your job to figure out if there are enough 
employees available to work during the week. To keep things simple, the store hours are Mondays to Fridays, 9am-9pm 
every day. Employees are allowed to sign up for shifts for 3-hour slots (9am-noon, noon-3pm, 3pm-6pm, and 6pm-9pm). 
In the test class below called `StoreHours`, two employees named "Ann" and "Bob" have indicated their availability
which is then combined into overall worker availability for each possible shift. Your task is to complete the 
`Employee` and `WorkSchedul` classes in this question. More details below.

## Employee Class

### Attributes

- All the following attributes should not be visible from another class.
- A `String` attribute called **name**.
- A two-dimensional `boolean` array called **availability**. This array represents which day and time slot of the week 
  the person is available to work.

### Constructor

- The constructor must be visible from another class.
- This constructor must accept a `String` to initialize the **name** attribute.
- The **availability** array should be initialized to the *static* values from the `WorkSchedule` class. The number of
  rows should be initialized to **NUM_DAYS**, and the number of columns should be initialized to **NUM_SLOTS**.

### Methods

### Get Availability
- A method that is accessible to other classes called `getAvailability`
- It should accept no parameters and return the **availability** array. 

#### Add Time

- A method that returns a nothing and is accessible to other classes called `addTime`.
- This method must accept two `int` values as parameters. The `int` values act as indexes to the **availability**
  array with the first `int` representing the day and the second the slot.
- The method should check that the `int` values are within the bounds of the array and if so, change the corresponding
  value to `true`. Otherwise, do nothing.

#### To String

- A `toString` method which maps the boolean values in **availability** into words. The `String` should contain 
  the **name** of the `Employee` and a shortened version of the name of every day (Mon, Tue, Wed, Thu, Fri) followed 
  by a space and a list of the shifts they are available for (9am-noon, noon-3pm, 3-6pm, 6-9pm). Each day should be 
  printed on its own line. If there are no shifts, there should still be a space at the end of the line but otherwise
  there should be no extra space. There should be an extra line break after the Fri line.
- For example, an `Employee` with the **name** `Lila` and an **availability** of:

| Grid  | 0     | 1     | 2     | 3     |
|-------|-------|-------|-------|-------|
| Row 0 | true  | true  | false | false |
| Row 1 | false | false | false | false |
| Row 2 | false | false | true  | false | 
| Row 3 | false | false | true  | false | 
| Row 4 | true  | true  | true  | true  | 

  would return the following `String`:
- ```
  Availability for Lila:
  Mon: 9am-noon, noon-3pm
  Tue: 
  Wed: 3-6pm
  Thu: 3-6pm
  Fri: 9am-noon, noon-3pm, 3-6pm, 6-9pm
  
  ```

## WorkSchedule Class

### Attributes

- A *final* *static* `int` attribute called **NUM_DAYS** that should be visible from other classes and be set to `5`. 
- A *final* *static* `int` attribute called **NUM_SLOTS** that should be visible from other classes and be set to `4`.
- A `String` attribute called **week** that should not be visible from another class.
- A two-dimensional `int` array called **timetable** that should have **NUM_DAYS** rows and **NUM_SLOTS** columns, 
  like the **availability** array in `Employee`. This **timetable** keeps track of how many employees can work any 
  given shift. It should not be visible from another class.

### Constructor

- The constructor must be visible from another class.
- This constructor must accept a `String` and an `Employee[]` as parameters.
- The `String` should be used to initialize the **week** attribute, and the `Employee[]` should be used to call the
  `howManyAvailable` method.

### Methods

#### How Many Available

- A method that returns nothing and is not accessible to other classes called `howManyAvailable`.
- This method must accept an `Employee[]` as a parameter.
- It should iterate through each `Employee` in the array and call the `getAvailability` method which should return a
  2-dimensional `boolean` array that has matching dimensions to the **timetable** array. For each value in the 
  **availability** array that is `true` increment the value in **timetable** at the matching indexes by `1`.

#### To String

- A `toString` method which translates the **timetable** array into words. It should return
  "Number of employees available to work for each time slot: " on its own line followed by the values in each row of the
  array also on their own line prefaced by the shortened form of the day of the week (Mon, Tue, Wed, Thu, Fri). Each number
  should be preceded by two empty spaces, and each line should have no extra spaces at the end of it. There should be
  an extra empty line following the Fri line.
- Sample String:
  ```
  Number of employees available to work for each time slot:
  Mon:  2  1  0  1
  Tue:  1  0  0  2
  Wed:  1  0  3  0
  Thu:  2  1  1  0
  Fri:  1  1  1  2
  
  ```
