# oop-object_interactions-hard-q4

- Java question

## Question Text

Some data should be encrypted, however to do so you need a key to base the encryption off of. Design a `CryptBox` class
using the provided class components, and create a `crossEncrypt` method that takes another `CryptBox` object and 
uses that object's key to encrypt the other object's data.

### CryptBox Class:

Your `CryptBox` class should have the following items:

- Attributes:
    - A `String` attribute called **lockedData**
    - An `int` attribute called **cryptKey**
    - Both of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class that accepts a `String` and an `int` parameter, and initializes the 
      **lockedData** attribute with the `String` and the **cryptKey** attribute with the `int`

- Methods
    - A `getCryptKey` method which is visible from another class and returns the **cryptKey** attribute of the `CryptBox`
    - A `crossEncrypt` method which takes a `CryptBox` parameter and uses the **cryptKey** attribute of that object to
    transform the first object's **lockedData** by adding the `int` to each character of the `String`. The method 
    should then return the encrypted **lockedData**. This method should be accessible by another class.

## TestEncryption Class

Your `TestEncryption` class must have the following items:

- Main Method:
    - A `main` method which initializes two `CryptBox` objects, one with a **lockedData** value of `Hello there` and a 
      **cryptKey** value of 3 and the other with a **lockedData** value of `The car is new` and a **cryptKey** value
      of 7.
    - Then, call the first object's `crossEncrypt` method with the second `CryptBox` object as input
    - Display `"Encrypted message is: "` followed by the newly encrypted `String`
