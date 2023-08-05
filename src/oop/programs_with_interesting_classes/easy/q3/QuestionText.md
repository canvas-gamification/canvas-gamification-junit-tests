# oop-programs_with_interesting_classes-easy-q3

- Parsons Question

## Question Text

The local hospital wants you to make a reminder application that will take in a patient's name and the number of days since their last checkup. Make a class called `AnnualCheckup` using the requirements below for this purpose.

### AnnualCheckup Class

The `AnnualCheckup` class has the following requirements:

- Attributes
  - Note that none of the attributes in this class should be visible from another class
  - A `String` attribute called **patient**
  - An `int` attribute called **numDays**

- Constructors:
  - A constructor visible from another class that accepts a `String` and an `int` as parameters, and uses the values to initialize the **patient** and **numDays** attributes

- Methods:
  - A method called `remindMe`
    - This method must be visible from another class
    - It must return nothing and have no parameters
    - The method must check that the value of the **numDays** field is greater than or equal to `365`. If it is, then print out the string "Patient x is due for a checkup", where x is the value of the **patient** field. If **numDays** is less than `365`, the method must print "x has y day(s) until their next checkup is due.", where x is the value of the **patient** field, and y = `365 - numDays`, and then increment the **numDays** field by one.
