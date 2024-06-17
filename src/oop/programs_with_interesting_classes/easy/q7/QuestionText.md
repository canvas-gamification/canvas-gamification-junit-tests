# oop-programs_with_interesting_classes-easy-q7

- Parsons Question

Lots of songs have the same name and it can be difficult to keep track of which songs are which. Make a class called 
`Song` to keep track of music files using the requirements below. Then make a `Playlist` class that arranges `Song` 
objects for preferred listening order using the next set of requirements below. Finally, make a Test class to test both 
the `Song` and the `Playlist` class using the last set of requirements.

### Song Class

The `Song` class has the following requirements:

- Attributes:
    - Note that none of the attributes in this class should be visible from another class
    - A `String` attribute called **title**
    - A `double` attribute called **length**
    - A `String` attribute called **artist**

- Constructors:
    - A constructor that accepts a`String`, a `double`, and a `String` as parameters, and uses the values to initialize 
      the **title**, **length**, and **artist** attributes in that order.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `toString` method that returns `"The x track by y is z minutes long."` where x is the value of the **title** 
      attribute, y is the value of the **artist** attribute, and z is the value of the **length** attribute. This method
      should be visible from other classes.

### Playlist Class

The `Playlist` class has the following requirements:

- Attributes:
    - Note that none of the attributes in this class should be visible from another class
    - An array of `Song` objects called **songs**
    - An `int` attribute called **numItems**

- Constructors:
    - A constructor visible from another class with no parameters that initializes the **songs** attribute to an array
      of 3 null `Song` objects and initializes the value of **numItems** to 0.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `toString` method that returns the songs in the playlist in format of String with `Playlist:` on the first line
      with each song then printing on a separate line using the `Song` class's `toString` method.
    - An `expandPlaylist` method that doubles the size of **songs** by adding new null objects while maintaining all the 
      existing songs.
    - An `addToPlaylist` method that takes a `Song` object and adds it after the last song of the **songs** attribute. If
      the **songs** attribute is full expand it using `expandPlaylist` method and then add the song. Use the **numItems** 
      attribute to keep track of where to place a `Song` object in the array.
    - All of these methods should be visible from other classes.

### Test class

- Main method:
    - In the main method create 5 `Song` objects and add them to a `Playlist` object in numeric order according to their
      variable names. Then print the songs in the playlist using the `toString` method.