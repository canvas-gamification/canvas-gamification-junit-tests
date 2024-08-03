# oop-programs_with_interesting_classes-medium-q8

- Parsons Question

## Question Text

Everybody hates it when their food goes bad in the refrigerator. In order to help people save money and be mindful of 
food waste, some companies have been working on a smart fridge app that warns you before your food expires. Make a Java 
class called `Food`, another called `Fridge`, and a test class called `TestSmartFoodManagement` using the requirements
below.

### Food Class

Your `Food` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - an `int` attribute called **daysToExpiration**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` and an `int` in that order to initialize the **name** and **daysToExpiration**
      attributes.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `getName` method which returns the value of the **name** attribute
    - A `getDaysToExpiration` method which returns the value of the **daysToExpiration** attribute
    - An `increaseExpirationLength` method which increments the value of the **daysToExpiration** attribute by 1
    - A `decreaseExpirationLength` method which decrements the value of the **daysToExpiration** attribute by 1
    - A `toString` method that returns a String of the form "x will expire in y days" where x is the value of the **name** 
      attribute, y is the value of the **daysToExpiration** attribute.

### Fridge Class

Your `Fridge` class must have the following requirements:

- Attributes:
    - a `Food[]` attribute called **items**
    - a `double` attribute called **currTemperature**
    - all of these attributes must not be accessible from another class

- Constructor:
  - The constructor should accept a `Food[]` and a `double` in that order to initialize the **items** and **currTemperature**
    attributes.
  - This constructor should be accessible from another class.

- Methods:
  - All the following methods should be visible from another class, and if there is no return type specified, assume
    it should return nothing.
  - A `getItems` method which returns the **items** attribute
  - A `decreaseTemperature` method which decrements the **currTemperature** attribute by 10 and calls the `increaseExpirationLength`
    method on each Food in **items**
  - An `increaseTemperature` method which increments the **currTemperature** attribute by 10 and calls the `decreaseExpirationLength`
    method on each Food in **items**
  - A `getNextToExpire` method which uses the `getDaysToExpiration` method to identify which Food in **items** will
    expire soonest and returns it.

### TestSmartFoodManagement Class

Your `TestSmartFoodManagement` Class must have the following methods:

- Main method:
  - A `main` method to run the class from.
  - It must initialize five `Food` objects. The first should be named `"Apples"` and have a **daysToExpiration** of `20`.
    The second should be named `"Bananas"` and have a **daysToExpiration** of `10`. The third should be named `"Tomatoes"` 
    and have a **daysToExpiration** of `7`. The fourth should be named `"Ketchup"` and have a **daysToExpiration** of `180`. The 
   fifth should be named `"Chicekn"` and have a **daysToExpiration** of `4`.
  - Then add these `Food` items to an array and use it to initialize a `Fridge` with a **temperature** of `4.5`.
  - Then, print the list of **items** using the Arrays.toString() method.
  - After, call the `getNextToExpire` method on the `Fridge` and print the result.
  - Finally, call the `decreaseTemperature` method and print the information for the next food to expire again.
