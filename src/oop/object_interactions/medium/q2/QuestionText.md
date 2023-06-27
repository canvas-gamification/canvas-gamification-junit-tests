# oop-object_interactions-medium-q2

- Java question

## Question Text

Many people keep secrets that they only share with a trusted friend. Make a class called **Person** that has a secret
and potentially knows about the secrets of their friends. This class has several attributes: **myName**, **mySecret**,
a list of names of **friends**, and a list of **secrets** from those friends.

## Person Class

The `Person` class currently has the following items:

- Attributes:
    - A `String` called **myName**
    - A `String` called **mySecret**
    - An array of `String` called **friends**
    - An array of `String` called **secrets**
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
      Your method should find the friend using the input name in the **friendNames** attribute and if the index of
      friend is i, it should change the value of **friendSecrets** at i to the value of the input for the secret.
    - A `writeInDiary` method which prints `I have the following secrets:` and then prints each secret that the
      **Person** knows in each line. It should write the secret in the following format:
      if friend `Ginger` has the secret `she is scared of bears` it should be
      like `Ginger told me she is scared of bears.`

## TestFriendship Class

Your `TestFriendship` class must have the following items:

- Main Method:
    - A `main` method which initializes two **Person** objects, one with a **myName** value of `Ann` and **mySecret**
      value of `she hates chocolates` and the other with values of `Cam` and `she is scared of heights`.
    - Ann is friends with Bob and Cam in that order and Cam is only friends with Ann.
    - Use the **hearSecret** method to tell Ann's secret to Cam and use writeInDiary for Cam to write it in console.