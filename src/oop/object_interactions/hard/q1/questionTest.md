# oop-object_interactions-hard-q1

- Parsons question

## Question Text

Identity theft is a serious crime. Design a Passport class using the requirements below, and create a steal method that
takes the attributes from one passport and copies them to another.

### Passport Class:

Your `Passport` class must have the following items:

- Attributes:
    - A `String` attribute called **name**
    - A `String` attribute called **dob**
    - Both of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class that accepts two `String` parameters, and initializes the **name** field
      with the first `String` and the **dob** field with the second `String`
    - This constructor should be visible from another class

- Methods
    - Note that unless otherwise specified, the following methods should be visible from another class
    - A `getName` method which returns the **name** attribute of the passport
    - A `getDob` method which returns the **dob** attribute of the passport
    - A `setName` method which takes a `String` parameter and updates the **name** field to that value. This method
      should not be visible from other classes
    - A `setDob` method which takes a `String` parameter and updates the **dob** field to that value. This method should
      not be visible from other classes.
    - A `toString` method which returns a `String` describing the Passport object. It should be of the format "My name
      is x, and I was born on y." where x is the **name** attribute and y is the **dob** attribute of the passport
    - A `steal` method that accepts a `Passport` as a parameter and copies the passed passports **name** and **dob**
      values to the passport the method was called on
    