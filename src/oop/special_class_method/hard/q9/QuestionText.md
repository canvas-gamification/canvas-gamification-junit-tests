# oop-special_class_method-hard-q9

## Question Text

Many people are fascinated by our planet's solar system. Make a Java class called **Earth** with two attributes; a
`double` **landMass** and an `int` named **population**. **Earth** should have a constructor visible from other classes
which accepts a `double` and `int` (in that order) and initializes the corresponding attributes using these values.
Also, these attributes must not be accessible from other classes. As such, compose the necessary methods so that these
attributes can be accessed and modified from outside the class.

### Earth Class:

Your `Earth` class must have the following items:

- Attributes:
    - A `double` attribute named **landMass** which is not accessible from other classes
    - An `int` attribute named **population** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a`double` and a `String` to initialize the
      **landMass** and **population** attributes.

- Methods:
    - a `setLandMass` method which accepts a `double` value, updates the **landMass** attribute with it, and is
      accessible
      from other classes
    - a `getLandMass` method which is accessible from other classes and returns the value of the **landMass** attribute
    - a `setPopulation` method which accepts an `int` value, updates the **population** attribute with it, and is
      accessible
      from other classes
    - a `getPopulation` method which is accessible from other classes and returns the value of the **population**
      attribute
    - a `toString` method which returns a String of the information about the `Earth` class of the form
      `"Here " + population + "people live on a " + landMass + "kg planet."`.

### Distractors:

- setLandMass( lm );
- setPopulation( p );
- return Population;
- return population = a;
- public int population;
- public double landMass;
- private class Earth
- public Earth()
- int population;
- double landMass;
- public String toString()
- public static void setLandMass(double a)
- private Earth( double landMass, int population) 	
