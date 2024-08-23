# oop-programs_with_interesting_classes-hard-q7

- Java Question

## Question Text

A local daycare wants you to build an educational application to help children learn basic geography. The idea is 
that a child can select a specific country and an animal from that country makes a sound. Consider the test class 
below called `Globe`. The program creates a few animals and adds them to some countries where they can be found. A 
text menu of options is listed for the user to select from which will play a random animal sounds from that country. 
This test class requires an `Animal` and `Country` class which you will have to write. More details below.

### Animal Class

Your `Animal` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - a `String` attribute called **sound**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept two `String` parameters and initialize the **name** attribute to the first value
      and the **sound** attribute to the second value.
    - The constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class.
    - A `getName` method which returns the **name** attribute.
    - An `getSound` method which returns the **sound** attribute.
    - A `toString` method which returns a `String` in the form of "x makes the noise y" where x is the value of 
      **name** and y is the value of **sound**.

### Country Class

Your `Country` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - an `Animal[]` attribute called **localAnimals**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` and an `Animal[]` as parameters and use them to initialize the **name**
      and **localAnimals** attributes.
    - The constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `getName` method which returns the value of **name**.
    - A `setLocalAnimals` method which accepts an `Animal[]` and uses it to set the value of **localAnimals**.
    - A `getRandomAnimal` method which returns a random `Animal` from its **localAnimals** array.
    - A `toString` method which returns a `String` in the form of "x has: [a, b, ..., z]" where x is the value of 
      **name** and [a, b, ..., z] is the values of the **localAnimals** attribute. Hint: Arrays.toString() can be
      used here.
