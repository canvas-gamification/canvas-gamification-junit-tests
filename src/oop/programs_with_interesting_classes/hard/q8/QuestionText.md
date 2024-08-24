# oop-programs_with_interesting_classes-hard-q8

- Java Question

# Question Text

As a student, you wish you had more time to pursue your hobbies or work in a part-time position while taking a full 
course load. You decided to write a program to help you estimate your workload and how much spare time you have in a 
week. The following test class called `TestSemester` will get you started below. In this class, five courses are 
created complete with weekly study and homework time estimates which the program uses to calculate the work load and 
display how much spare time you have left in the week. Your task is to complete the method definitions missing from 
`TestSemester`, and to define a `Course` class. You will not be graded on the provided code in the main method of 
`TestSemester`. More details are provided below.

### Course Class

Your `Course` class must have the following requirements:

- Attributes:
    - a *final* `int` attribute called **STUDY_HOURS** which represents the number of hours a week you need to study
      per exam.
    - a *final* `int` attribute called **HOMEWORK_HOURS** which represents the number of hours a week you need to work
      on a given homework item.
    - a *final* `String` attribute called **COURSE_CODE**
    - an `int` attribute called **numExams** which represents the number of exams in the course.
    - an `int` attribute called **numHwk** which represents the number of homework items per week;
    - all of these attributes must not be accessible from another class.

- Constructor:
    - The constructor should accept a `String` and four `int` values to initialize the **COURSE_CODE**, **numExams**,
      **numHwk**, **STUDY_HOURS**, and **HOMEWORK_HOURS** attributes in that order.
    - The constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `getCOURSE_CODE` method which returns the **COURSE_CODE** attribute.
    - A `setNumExams` method which accepts an `int` as a parameter and sets the **numExams** attribute to that value.
    - A `setNumHwk` method which accepts an `int` as a parameter and sets the **numHwk** attribute to that value.
    - A `calcWeeklyLoad` method which returns an `int` which is the sum of **numExams** multiplied by **STUDY_HOURS**
      and **numHwk** multiplied by **HOMEWORK_HOURS**.
    - A `toString` method which returns a `String` in the format "Course x has y homework assignments and z exams";
      where x is the value of **COURSE_CODE**, y is the value of **numHwk**, and z is the value of **numExams**.

## TestSemester Class

### Methods

#### Calculate Workload

- A method that is **static** and accessible to other classes called `calculateWorkload`.
- This method must accept a `Course[]` as a parameter and returns an `int`.
- The method should iterate through the array and add up the values returned by the `calcWeeklyLoad` method for each 
  `Course` as well as adding 3 hours per `Course` for lecture hours. It should return the summed value.

#### Display Spare Time

- A method that is **static** and accessible to other classes called `displaySpareTime`.
- This method must accept an `int` that represents how many hours a week school occupies and return nothing.
- This method should calculate the number of hours in a week and subtract the `int` parameter from that value.
  It should also subtract 8 hours per day for sleep.
- Finally, it should print the calculated value in the form "This week you will have x hours of spare time." where
  x is the calculated value.
