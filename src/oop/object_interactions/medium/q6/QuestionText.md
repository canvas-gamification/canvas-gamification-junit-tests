# oop-object_interactions-medium-q6

- Java question

## Question Text

Companies constantly overbook available seats which causes a lot of passenger frustration. To solve this problem, 
airlines sometimes transfer passengers to different flights. Make a class called **Airplane** and another called 
**testBooking** with the following descriptions to help with that process.

## Airplane Class

The `Airplane` class currently has the following items:

- Attributes:
    - An `int` called **maxSeats**
    - An `int` called **numPassengers**
    - None of these attributes should be accessible from other classes.

- Constructors:
    - A constructor that takes one `int` to initialize the **maxSeats** attribute and initializes the **numPassengers**
      attribute to zero.
    - A constructor that takes two `int` parameters to initialize the **maxSeats** and **numPassengers** attributes.
    - Both are accessible from other classes.

- Methods:
    - Getter and Setter methods for the **maxSeats** and **numPassengers** attributes.
    - These methods are accessible from other classes.

You must add the following items to the class:

- Methods:
    - A `transferPassengers` method that takes another **Airplane** called **busyPlane** and moves passengers of 
      **busyPlane** to this Airplane until it is full. If this plane is already full it should print 
      `This plane is full too and cannot accommodate anymore passengers`. If the plane is not full it should move as 
      many passengers as possible over into the plane and then write `We moved n passengers` where n is the number of 
      passengers moved.
    - A `toString` method that returns a `String` of information in the format of `x out of y seats are filled`. Where
      x is the value of **numPassengers** and y is the value of **numSeats**.
    - All methods must be accessible from other classes.

## TestBooking Class

Your `TestBooking` class must have the following items:

- Main Method:
    - A `main` method which initializes three **Airplane** objects which respectively have 12 seats and 20 passengers, 6
      seats and 0 passengers, and 4 seats and 0 passengers.
    - First move extra passengers from the first plane to second plane. Then move the rest from first to the third
      airplane.
    - Second print the information of the three **Airplane** objects in order using **toString**. Use this format:
      `"The first ride: 3 out of 10 seats are filled"`.