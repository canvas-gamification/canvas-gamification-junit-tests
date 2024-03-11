# oop-object_interactions-medium-q2

- Java question

## Question Text

Many people keep secrets that they only share with a trusted friend. Make a class called **Person** that has a secret 
and potentially knows about the secrets of his/her friends.
Also, make a **TestFriendship** class to test the Person class.

## Person Class

The `Person` class currently has the following items:

- Attributes:
    - A `String` called **myName**
    - A `String` called **mySecret**
    - An array of `String` called **friendNames**
    - An array of `String` called **friendSecrets**
    - None of these attributes should be accessible from other classes.

- Constructors:
    - a constructor that takes a `String` for initializing the **myName** attribute, another `String` for initializing
      the **mySecret** attribute, and an array of `String` for initializing the **friendNames** attribute.
    - It should initialize the **friendSecrets** array as an array of null `String` with the size of **friendNames**
      attribute that is previously initialized with the input array of `String`.
    - It should be accessible from other classes.

- Methods:
    - Getter methods for **myName** and **mySecret** attributes that are accessible from other classes.

You must add the following items to the class:

- Methods:
    - A `hearSecret` method that takes two `String`. One is the name of a friend and the other is that friend's secret.
      Your method should find the friend using the names in the **friendNames** attribute and it should change the
      value of **friendSecrets** at the same index as the friend is found in **friendNames**, if you do not find the
      name you must not change anythim.
    - A `writeInDiary` method which prints `I have the following secrets:` in first line and then prints each secret
      that the **Person** knows on a separate line only if there is a secret. Given a friend `Ginger` and a secret
      `she is scared of bears` it should write the secret in the following format: `Ginger told me she is scared of bears.`

## TestFriendship Class

Your `TestFriendship` class must have the following items:

- Main Method:
    - A `main` method which initializes two **Person** objects, one with a **myName** value of `Ann` and **mySecret**
      value of `she hates chocolates` and the other with values of `Cam` and `she has failed Math`. Ann is friends
      with Bob and Cam in that order and Cam is only friends with Ann.
    - Use the **hearSecret** method to tell Ann's secret to Cam and use writeInDiary for Cam to write it in console.