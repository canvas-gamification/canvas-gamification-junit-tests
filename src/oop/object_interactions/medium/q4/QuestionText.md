# oop-object_interactions-medium-q4

- Java question

## Question Text

You are working as a vet assistant in an animal hospital, and sometimes you encounter an animal that requires a blood 
transfusion to save its life.  Using the following description, make a class called **Snail** 
to model this situation, and a class called **TestTransfusion** to test your **Snail** class.

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
    - Getter and Setter methods for **bloodType** and **volume**.
    - These methods are accessible from other classes.

You must add the following items to the class:

- Methods:
    - A `toString` method that prints the object information in the format
      `My blood type is x and I have yL of blood left` where x is the **bloodType** value and y is the **volume** value.
    - A `transfusionFrom` method that take another **Snail** object to do a blood tansfer.
    - It should check if the blood types are a match and if not print `Blood type incompatible`. Note that in this scenario
  **Snail** blood types are not like humans, so you should check that the type match exactly.
    - If the types are compatible it should print `Checking if donor has enough blood for a transfusion...`
    - Then it should make sure that the donor has more than 5 unit of blood if not
      it should print `Donor does not have enough blood for a transfusion`.
    - If the donor has enough take 1 unit of blood from the donor
      and give it to the snail, and then print `Blood transfusion completed`.

## TestTransfusion Class

Your `TestTransfusion` class must have the following items:

- Main Method:
    - A `main` method which initializes three **Snail** objects called Sarah, Jones, and Cindy who respectively have
      blood type A, B, and B, and blood volume of 10.5, 8, and 0.5.
    - Cindy should try to get blood from first Sarah and then Jones.
    - Then it should print the information of Sarah, Jones, and Cindy in that order using **toString()** method.
    - An example of the output would be `"Sarah: " + sarah.toString()`.
    - Each output must be on a separate line.