# oop-object_interactions-medium-q5

- Java question

## Question Text

Transplant surgeons and researchers investigate the possibility of cross-species transplantation between humans and
animals that share similar traits. Make a class called **Person** with attributes **myName** and **numEyes** that are
initialized by the constructor. The class has a method called **receiveDonation** from a donor where a body part is
transplanted as long as that body part is available.

## Person Class

The `Person` class currently has the following items:

- Attributes:
    - A `String` called **myName**
    - An `int` called **numEyes**
    - None of these attributes should be accessible from other classes.

- Constructors:
    - A constructor that take a `String` and an `int` to initialize the **bloodType** and **volume** attributes.
    - It is accessible from other classes.

- Methods:
    - Getter and Setter methods for **myName** and **numEyes** attributes
    - These methods are accessible from other classes.

You must add the following items to the class:

- Methods:
    - A `receiveDonation` method that take another **Person** object called donor to do a transplant.
    - It should check if the **numEyes** in donor is non-zero.
    - If donor has enough take 1 unit of **numEyes** from donor
      and give it to the **Person**, and then print `Transplant successful`.
    - A `toString` method that return the `String` of information in the format
      of `myName + " has " + numEyes + " eyes"`

## TestTransplant Class

Your `TestTransplant` class must have the following items:

- Main Method:
    - A `main` method that initializes two **Person** objects named Tom and Jim, where Tom has 2 eyes and Jim has zero, and prints
      them using **toString()**. Print Tom's information first and Jim's second. Then have Jim recieve a transplant from Tom.
    - Then print the information of the two **Person**, Tom and Jim in that order, with **toString()**.