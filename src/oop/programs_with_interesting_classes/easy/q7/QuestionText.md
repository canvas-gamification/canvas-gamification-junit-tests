# oop-programs_with_interesting_classes-easy-q7

- Parsons Question

### Song Class

The `Song` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - A `String` attribute called **title**
    - A `double` attribute called **length**

- Constructors:
    - A constructor visible from another class that accepts a`String` and a `double` as parameters, and uses the values
      to initialize the **title** and **length** attributes
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `toString` method that returns `"The x track is y minuets long."` where x is the value
      of the **title** attribute and y is the value of the **length** attribute.

### Playlist Class

The `Playlist` class has the following requirements:

- Attributes
    - Note that none of the attributes in this class should be visible from another class
    - An array of `Song` objects called **songs**
    - An `int` attribute called **numItems**

- Constructors:
    - A constructor visible from another class with no parameters that initializes the **songs** attribute to an array
      of 3 null `Song` objects and initializes the value of **numItems** to 0.
    - Note that this constructor should be visible from all other classes.

- Methods:
    - A `toString` method that returns the songs in the playlist in format of String with `Playlist:` on the first line
      and each songs information using `toString` in a separate line.
    - An `expandPlaylist` method that doubles the size of playlist while keeping all the songs already in there (adding
      null objects).
    - An `addToPlaylist` method that takes a `Song` object and add it after the last song of **songs** attribute. If
      the **songs** attribute is full expand it using `expandPlaylist` method and then add the song after the last song.
    -

### Test class

- Main method:
    - In the main method create 5 `Song` add them to a `Playlist` object and then print the songs in the playlist using
      `toString` method.