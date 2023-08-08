# oop-static_modifier-medium-q5

- Question Type: Java

## Question Text

As the manager of a local apparel store, you are tasked with modelling your store's selection. Make a Java program
called **Hat** that has a static variable called **companyLogo** that is shared by all the objects of the class.

### Hat Class

Your `Hat` class already the following items:

- Attributes:
    - A `String` attributes called **colour**.
    - Note that all attributes in this class are private

- Constructors:
    - A constructor that accepts a `String` and initializes the **colour** attribute.
    - This constructor is accessible from other classes.

You need to add the following items:

- Attributes:
    - A `String` attribute called **companyLogo** that has its value, initially `Nike`, shared by all **Hat** instances.
    - Note that all attributes in this class should be private

- Methods:
    - a `toString` method which returns a String of the information about the `Hat` class of the form
      `This is a x Hat that is y in colour` where x is the value of **companyLogo** attribute and y is the
      value of **colour** attribute

### Test Class:

Your `Test` class will have a main method which initializes a `Hat` of **colour** value of `"Green"`. Then,
print the toString for this class.