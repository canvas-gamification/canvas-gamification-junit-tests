# oop-object_interactions-medium-q4

- Java question

## Question Text

You are working as a vet assistant in an animal hospital, and sometimes you encounter an animal that requires a blood
transfusion in order to save its life. Make a class called **Snail**
with attributes **bloodType** and **volume** that are initialized by the constructor. This class has a method called
**transfusionFrom()** that checks if the two animals have the same blood type and whether the donor has enough blood
before starting the transfusion. If both conditions pass, then 1L of blood is transferred from the donor to the
recipient.

## Snail Class

The `Snail` class currently has the following items:

- Attributes:
    - A `char` called **bloodType**
    - A `double` called **volume**
    - None of these attributes should be accessible from other classes.

- Constructors:
    - A constructor that take a `char` and a `double` to initialize the **bloodType** and **volume** attributes.
    - It is accessible from other classes.

- Methods:
    - Getter and Setter methods for **bloodType**, **volume**, and  **toString** method that prints the object
      information.
    - These methods are accessible from other classes.
    -

You must add the following items to the class:

- Methods:
    - A `transfusionFrom` method that take another **Snail** object to do a blood tansfer.
    - It should check if the blood types are a match and if not print `Blood type incompatible`.
    - If the types are compatible it should say `Blood transfusion starting...`
    - Then it should make sure that the donor has more than 5 unit of blood if not
      it should print `Donor does not have enough blood for a transfusion`.
    - If donor has enough take 1 unit of blood from donor
      and give it to the snail, and then print `Blood transfusion completed`.

## TestTransfusion Class

Your `TestTransfusion` class must have the following items:

- Main Method:
    - A `main` method which initializes three **Snail** objects called Sarah, Jones, and Cindy who respectively have
      blood type A, B, and B, and blood volume of 10.5, 8, and 0.5.
    - Cindy should try to get blood from first Sarah and then Jones.
    - Then it should print the information of Sarah, Jones, and Cindy in that order using **toString()** method.
    - An example of the output would be `"Sarah: " + sarah.toString()`.