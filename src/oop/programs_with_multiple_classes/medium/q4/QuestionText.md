# oop-programs_with_multiple_classes-medium-q4

You want to write a program that models vehicular components within different types of vehicles. Make a Java program with the following requirements:


## Wheel

Your `Wheel` class should have the following items:

- Attributes:
    - An `double` called **durability**
    - A `String` called **manufacturer**

- Constructors:
    - A `public Wheel(double, String)` constructor to set the
      **durability** and **manufacturer** in that order

## Chassis

Your ``Chassis`` class should have the following items:

- Attributes:
    - An `String` called **materialType**

- Constructors:
    - A `public Chassis(String)` constructor to set the
    - **materialType** field

## TestVehicle

- Your `TestVehicle` class will have a `main` method which initializes one Chassis and four wheels, and prints out the
  attributes of each object. Use the `toString` method provided in each class to do this.
- The sample output is as follows:
  ```
  Chassis: Chassis{materialType = Steel}
  Wheel 1: Wheel{durability = 5.5, manufacturer = Milani}
  Wheel 2: Wheel{durability = 5.5, manufacturer = Milani}
  Wheel 3: Wheel{durability = 6.9, manufacturer = TRX}
  Wheel 4: Wheel{durability = 6.8, manufacturer = RTX}
  ```