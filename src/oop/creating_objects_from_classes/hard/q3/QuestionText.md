# oop-creating_objects_from_classes-hard-q3

Note: for this question give the student the entire Tomato file, except for the `plantSeed(String[] names)` method
You can just leave a comment saying something like // add your plantSeed(String[] names) method here

## Question Text

Suppose you have defined a `Tomato` class, and now you want to add a method with the following header: 
`public Tomato plantSeed(String[] names)`. 
This method initializes and returns a `Tomato` object based on the length of the names array. The names array contains
values for the class attributes in the following order: name, flavour, usedFor. It may contain either 0, 1, 3, or more
than 3 of the attributes.

E.g.
```
String[] names = new String[]{"Grape Tomato"};
Tomato parentTomato = new Tomato();
Tomato childTomato = parentTomato.plantSeed(names);
```
In this example, childTomato will have name "Grape Tomato," and none of its other fields will be initialized.

You should use the given constructors to perform the initialization.
