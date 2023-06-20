# oop-object_interactions-hard-q2

- Java question

## Question Text

Modern married couples often combine each other's last names to create a new last name for their family. Design a 
`Partner` class using the requirements below, and create a marryMe method that takes the last name of another partner
and creates a hyphenated last name.

### Partner Class:

Your `Partner` class must have the following items:

- Attributes:
    - A `String` attribute called **firstName**
    - A `String` attribute called **lastName**
    - Both of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class that accepts two `String` parameters, and initializes the **firstName** 
      attribute with the first `String` and the **lastName** attribute with the second `String`
    - This constructor should be visible from another class

- Methods
    - The following methods should be visible from another class
      - A `marryMe` method which takes a `Partner` object and changes the last names of both objects to a hyphenated 
        version of their unmarried names. Where the format is `lastName-passedLastName`.
    - A `getFirstName` method which returns the **firstName** attribute of the partner
    - A `getLastName` method which returns the **lastName** attribute of the partner
    - A `setFirstName` method which takes a `String` parameter and updates the **firstName** attribute to that value. 
    - A `setLastName` method which takes a `String` parameter and updates the **lastName** attribute to that value. 
    - A `toString` method which returns a `String` describing the `Partner` object. It should be of the format "My name
      is: x y." where x is the **firstName** attribute and y is the **lastName** attribute of the partner
