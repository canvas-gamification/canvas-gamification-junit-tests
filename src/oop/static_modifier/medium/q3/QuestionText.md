# oop-static_modifier-medium-q3

- Question Type: Parsons with distractors

## Question Text

Suppose you are the owner of a noisy animal farm. Typically, the animals make their sounds as a way to communicate with 
you. When you have not visited them for a long time, they will make a louder, whiny sound. Once they see you a lot, they 
noise returns to being shorter. Use the requirements below to code a `Horse` class in Java.

### Horse Class

Your `Horse` class must have the following items:

- Attributes:
    - A static `String` attribute called **noise** which is set to `Neigh!`
    - A `String` attribute called **name**
    - Note that all attributes in this class should be private

- Constructors:
    - A constructor that accepts a `String` to initialize the **name** attribute of the `Horse`

- Methods:
    - All methods should be visible from another class 
    - A `lengthenSound` method which finds the first vowel in the sound and inserts it an extra four times into the 
      noise. This method does not return anything. If there is no vowel, the string should not be modified.
    - A `shortenSound` method which finds a vowel sound that has been extended to five of the same letter and shrinks
      it back down to one vowel. This method does not return anything. If there is no vowel, the string should not be modified.
    - A `toString` method which returns a `String` of the form `"x calls out y"` where x is the value of the **name** 
      attribute and y is the value of the **noise** attribute

# TestAnimal Class

Your `TestAnimal` class must have the following items:

- Main Method:
    - The main method should initialize two `Horse` objects
    - After initializing both objects, call the `lengthenSound` method
    - Then, print the `toString` value of each object on the same line, starting with the first object
    - Call the `shortenSound` method 
    - Finally, print the `toString` value of each object on the same line, starting with the first object