# oop-object_independence-medium-q4

## Question Info

- Question type: Java

### Question Text

You are about to take a long road trip so you want to build a simple portable player to keep yourself entertained on the 
trip. Make a class called **portableMusicPlayer** with the following description:

### PortableMusicPlayer Class

Your `PortableMusicPlayer` class must have the following items:

- Attributes:
    - An array of `String` called **playlist**
    - An `int` called **current**
    - Note that neither of these attributes should be visible from another class

- Constructors:
    - A single constructor with a parameter of an array of `String` that initializes the **playlist** attribute
    - It should initialize the **current** attribute to zero
    - This constructor should be visible from another class

- Methods:
    - a `play` method which is accessible from other classes and prints `"Now Playing : "` followed by the String in **playlist**
      at index **current**
    - a `playNext` method which is accessible from other classes, increments **current** by one and takes the remainder by the
      size of **playlist** and prints `"Now Playing : "` followed by the String in **playlist** at index **current**
    - a `playPrev` method which is accessible from other classes and decrements **current** by one and takes the remainder by
      the size of **playlist** and prints `"Now Playing : "` followed by the String in **playlist** at index **current**