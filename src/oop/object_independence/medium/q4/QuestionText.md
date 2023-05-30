# oop-object_independence-medium-q4

## Question Info

- Question type: Parsons

## Question Text

You are about to take a long road trip. So, you want to build a simple portable player to keep yourself entertained on
the trip. Make a class called **PortableMusicPlayer** with attributes called **playlist** and **current** that are
initialized in the constructor. The class has a method to play the item at the **current** index in the **playlist**, or
play the next item, or play the previous item.

### PortableMusicPlayer Class

Your `PortableMusicPlayer` class must have the following items:

- Attributes:
    - An array of `String` called **playlist**
    - An `int` called **current**
    - Note that neither of these attributes should be visible from another class

- Constructors:
    - A single constructor with a parameter of an array of `String` that initalzies the **ingredients** attribute
    - It should initialize the **current** to zero
    - This constructor should be visible from another class

- Methods:
    - a `play` method which is accessible from other classes and prints `"Now Playing : "` + the string in **playlist**
      at index **current**
    - a `playNext` method which is accessible from other classes and add one to current and takes it remainder for the
      size of **playlist** and prints `"Now Playing : "` + the string in **playlist**at index **current**
    - a `playPrev` method which is accessible from other classes and subtract one to current and takes it remainder for
      the size of **playlist** and prints `"Now Playing : "` + the string in **playlist**at index **current**