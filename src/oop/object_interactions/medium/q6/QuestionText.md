# oop-object_interactions-medium-q6

- Java question

## Question Text

Companies constantly overbook available seats which causes a lot of passenger frustration. Make a class called
**Airplane** that has **maxSeats** and **numPassengers** as attributes whose values are initialized by either a
constructor that is given the seating capacity or a constructor that is given input parameters for both attributes.
This class has a method called **transferPassengers()** whose purpose is to transfer the overflow of passengers from a
busy booking to a less busy booking. If the booking has enough empty seats, then it will accommodate all of the
overflow.
Otherwise, it just accommodates however many passengers it can until it is full. The resulting passengers that got moved
will be displayed.

## Airplane Class

The `Airplane` class currently has the following items:

- Attributes:
    - An `int` called **maxSeats**
    - An `int` called **numPassengers**
    - None of these attributes should be accessible from other classes.

- Constructors:
    - A constructor that takes one `int` and initialize the **maxSeats** attribute and initializes the **numPassengers**
      attribute to zero.
    - A constructor that take two `int` parameters to initialize the **maxSeats** and **numPassengers** attributes.
    - Both are accessible from other classes.

- Methods:
    - Getter and Setter methods for **maxSeats** and **numPassengers** attributes
    - These methods are accessible from other classes.

You must add the following items to the class:

- Methods:
    - A `transferPassengers` method that take another **Airplane** called **busyPlane** and move some of the
      passengers of **busyPlane** to this Airplane until this plane is full.
    - If this plane is already full it should write `This plane is full too and cannot accommodate anymore passengers`
    - If the plane is not full it should write `We moved n passengers` if n passengers are moved.
    - A `toString` method that return the `String` of information in the format
      of `myName + " has " + numEyes + " eyes"`
    - All methods must be accessible from other classes.

## TestTransfusion Class

Your `TestBooking` class must have the following items:

- Main Method:
    - A `main` method which initializes three **Airplane** who respectively have 12 seats and 20 passengers, 6 seats and
      zero passengers, and 4 seats and zero passengers.
    - First move extra passengers from the first plane to second plane. Then move the rest from first to the third
      airplane.
    - Then print the information of the three **Airplane** objects in order using **toString**.
    - Use this format: `"The first ride: " + first.toString()`.