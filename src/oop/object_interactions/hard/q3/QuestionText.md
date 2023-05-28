# oop-object_interactions-hard-q3

- Java question

## Question Text

People can save lives by donating blood regularly. You have volunteered to build an app that manages blood donors. Write
a `BloodDonor` class using the requirements below, and create a `canReceiveBloodFrom` method that checks if the 
`BloodDonor` can receive blood from another `BloodDonor`.

### BloodDonor Class:

Your `BloodDonor` class must have the following items:

- Attributes:
    - A `String` attribute called **name**
    - A `String` attribute called **bloodType**
    - Both of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class that accepts two `String` parameters, and initializes the **name**
      attribute with the first `String` and the **bloodType** attribute with the second `String`
    - This constructor should be visible from another class

- Methods
    - The following methods should be visible from another class
    - A `getName` method which returns the **name** attribute of the `BloodDonor`
    - A `getBloodType` method which returns the **bloodType** attribute of the `BloodDonor`
    - A `toString` method which returns a `String` describing the `BloodDonor` object. It should be of the format "x's
      blood type is y." where x is the **name** attribute and y is the **bloodType** attribute of the `BloodDonor`
    - A `canReceiveBloodFrom` method which accepts a `BloodDonor` object and returns a boolean describing if the passed
      object's **bloodType** is compatible with this object's **bloodType**. 
    - Note that a person can have a blood type of A, B, AB, or O. In general, a person with a certain blood type can 
      donate to another person of the same blood type. In addition, a person of blood type AB can receive blood from 
      another person of type A or type B. Lastly, a person of blood type O can donate blood to anyone.

# TestBlood Class

Your `TestBlood` class must have the following items:

- Main Method:
    - The main method should initialize two `BloodDonor` objects
    - The first object should have the **name** `Jill` and a **bloodType** of `A`
    - The second object should have the **name** `Jane` and a **bloodType** of `B`
    - After initializing both objects, print the `toString` value of each object, starting with the first object
    - Next, using the `canReceiveBloodFrom` method, check if the first object can receive blood from the second and 
      print either "They are compatible" or "They are incompatible"
    - Make sure that each of the messages are printed on their own line
    