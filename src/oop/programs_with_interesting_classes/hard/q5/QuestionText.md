# oop-programs_with_interesting_classes-hard-q5

- Java Question

# Question Text

Finding a good job is tough for everyone. Lots of people who aren't even on the job market still search for jobs because 
they want to better prepare themselves. Write a class called `JobAd` that works with the test class provided below 
called `ExploreJobs`. The test class shows several searches and displays those results but the methods called are not 
defined. Your task will be to complete those methods and to create the `JobAd` class. More details below.

### JobAd Class

Your `JobAd` class must have the following requirements:

- Attributes:
  - a `String` attribute called **title**
  - an `int` attribute called **salary**
  - a `String[]` attribute called **skills**
  - an `int` attribute called **numSkills**
  - all of these attributes must not be accessible from another class.

- Constructor:
  - The constructor should accept a `String` and an `int` to initialize the **title** and **salary** attributes.
  - It should initialize the **skills** attribute to an empty `String[]` of size `2` while **numSkills** should be
    initially set to `0`.
  - The constructor should be accessible from another class.

- Methods:
  - All the following methods should be visible from another class, and if there is no return type specified, assume
    it should return nothing.
  - A `getTitle` method which returns the **title** attribute.
  - A `getSalary` method which returns the **salary** attribute.
  - A `getSkills` method which returns the **skills** attribute.
  - An `addSkill` method which accepts a `String` as a parameter. If the **numSkills** value is less than the length
    of the **skills** array then the method should simply add the `String` at the index associated with **numSkills**
    and then increment the value of **numSkills**. If the **skills** array is not long enough to fit another `String`
    the method should create a new `String[]` with double the length of the **skills** array, and transfer over the
    elements in the **skills** array and reassigning **skills** to the newly created array before adding the new
    skill and incrementing **numSkills**.
  - A `toString` method which returns a `String` in the form of 
    ```
    Title:  x
    Salary: y
    Skills: a, b, ..., z
    
    ```
    where x is the value of **title**, y is the value of **salary**, and a, b, ..., z is all the elements of **skills**.
    Even if **skills** is empty, there should still be a line break included after an empty space.

## ExploreJobs Class

### Methods

#### Display Search Results

- A method that is **static** and accessible to other classes called `displaySearchResults`.
- This method must accept a `JobAd[]` as a parameter and return nothing.
- The method should iterate through the array and for each `JobAd` print its position in the list, starting at 1 not 0,
  and then print its information using the `JobAd` class's `toString` method.
```
Sample output:
Job Ad 1:
Title:  Project Manager
Salary: 75000
Skills: communication, detailed oriented, planning

Job Ad 2:
...
```

#### Search Min Salary

- A method that is **static** and is not accessible from other classes called `searchMinSalary`.
- This method must accept an `int` and a `JobAd[]` as parameters in that order and return a newly created `JobAd[]`.
- This method should search the given `JobAd` array for objects where the **salary** attribute is greater than or
  equal to the passed integer. It should then add them to a new array and return that new array.
- Note: the returned array should have no empty indexes.

#### Which Jobs Require

- A method that is **static** and is not accessible from other classes called `whichJobsRequire`.
- This method must accept a `String` and a `JobAd[]` as parameters in that order and return a newly created `JobAd[]`.
- This method should search the given `JobAd` array for objects where the any element in the **skills** array matches
  the given `String`. It should then add them to a new array and return that new array.
- Note: the returned array should have no empty indexes, and you must handle the potential null indexes in a **skills**
  array since your program cannot access **numSkills**.
