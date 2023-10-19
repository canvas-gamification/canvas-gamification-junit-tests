# oop-special_class_method-hard-q9

### Question Text

Many people are fascinated by our planet's solar system. Make a Java class called Earth that represents one of those
planets with the requirements below:

### Earth Class:

Your `Earth` class must have the following items:

- Attributes:
    - A `double` attribute named **landMass** which is not accessible from other classes
    - An `int` attribute named **population** which is not accessible from other classes

- Constructors:
    - A constructor which is accessible from other classes and accepts a `double` and an `int` to initialize the
      **landMass** and **population** attributes.

- Methods:
    - a `setLandMass` method which accepts a `double` value, updates the **landMass** attribute with it, and is
      accessible from other classes
    - a `getLandMass` method which is accessible from other classes and returns the value of the **landMass** attribute
    - a `setPopulation` method which accepts an `int` value, updates the **population** attribute with it, and is
      accessible from other classes
    - a `getPopulation` method which is accessible from other classes and returns the value of the **population**
      attribute
    - a `toString` method which returns a String of the information about the `Earth` class of the form
      `"Here x people live on a ykg planet."` where x is the value of **population** attribute and
      y is the value of **landMass** attribute.
    - Note that all of the setter methods must not return any value

### Distractors:

- return Population;
- return population = a;
- public int population;
- public double landMass;
- private class Earth
- public Earth()
- int population;
- double landMass;
- public static void setLandMass(double a)
- private Earth(double landMass, int population)
- public Earth(int population, double landMass)
