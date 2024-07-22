# oop-programs_with_interesting_classes-medium-q5

- Parsons Question

## Question Text

Many card games are played in groups where players compare their hand of cards and determine the winner. Make a Java 
class called `Card`, another called `Hand`, and one called `PlayGame` to test them. 

### Card Class

Your `Card` class must have the following requirements:

- Attributes:
    - a `char` attribute called **suit**
    - an `int` attribute called **rank**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `char` and an `int` in that order to initialize the **suit** and **rank**
      attributes.
    - Note that a card can have one of the following suits: 'S' for spades, 'H' for hearts, 'C' for clubs, and 'D' for 
      diamonds. The card rank is simplified to an integer in the range of 1 to 13. If either of these principles is
      violated set the attribute to a default value.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `getSuit` method which returns the **suit** attribute
    - A `getRank` method which returns the value of the **rank** attribute
    - A `toString` method that returns a String of the form "x of y" where x is the value of the **rank** attribute and 
      y is the value of the **suit**.

### Hand Class

Your `Hand` class must have the following requirements:

- Attributes:
    - a `Card[]` attribute called **myCards**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `Card[]` to initialize the **myCards** attribute.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `getMyCards` method which returns the **myCards** attribute
    - A `toString` method that returns a String of the form "x, y, ... z" where x, y, ... z are the to strings returned
      from the `Card` `toString` method.
    - A `compareHand` method which accepts a `Hand` object as input and determines the winner between the two hands. To
      determine the winner, the method checks all the cards in the hand to find the highest rank one, then the hand 
      with a higher value for the highest rank card is the winner. If both hands have the same highest value, the two
      hands tie.

### PlayGame Class

Your `PlayGame` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize four `Hand` objects using the `dealHand` method.
    - Then, announce the start of the first game and call the `compareHand` method on the first two hands.
    - After, call a rematch and call the `compareHand` method on the remaining two hands.

- DealHand method:
    - A method called `dealHand` which is accessible from any class, is *static*, returns a `Card[]` object, and accepts
      no parameters.
    - The method should initialize an array of 5 `Card` objects.
    - For each `Card` it should randomly select one of the four suits for the **suit** attribute, and generate a random
      integer between 1 and 13 for the **rank**.
    - Finally, it should return the array of `Card`s
