# oop-static_modifier-medium-q6

- Question Type: Java

## Question Text

Natural language processing is an area that analyzes text written or spoken by people with the ultimate goal of
designing communicative computer programs. Make a Java program called **TextProcessing** with the requirements below: 

### TextProcessing Class

Your `TextProcessing` class already has the following items:

- Attributes:
    - A `String` attribute called **text** that cannot be accessed in other classes

- Constructors:
    - A constructor that accepts a `String` and initializes the **text** attribute.
    - This constructor is accessible from other classes.

You need to add the following items:

- Attributes:
  - A `String` attribute called **indicator** that has its value, initially `, eh`, shared by all **TextProcessing** 
    instances, and is not visible from another class.

- Methods:
    - A `localize` method that adds the **inficator** to the end of **text**, and returns the phrase as
      if it were spoken by a local.
    - A `extractLocalizations`that uses the .replaceAll() method return a `String` where all instances of the 
      **indicator** have been removed from the **text** attribute.
    - Note that these methods are accessible from any class.