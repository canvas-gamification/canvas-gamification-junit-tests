# oop-static_modifier-medium-q4

- Question Type: Java

## Question Text

You want to make a program for the chemistry labs in a school that are making an experiment with household liquids.
Lots of different household items can make fun chemistry experiments. Make a Java program called **ChemistryLab** that
has two liquids from household items and a guide that says how much of which type of liquid is needed to make a
reaction. Note that all the labs in the school use the same source to get the liquid for their experiment, but they may
have different guides for the experiment.

### ChemistryLab Class

Your `ChemistryLab` class already the following items:

- Attributes:
    - Two static `double` attributes called **liquid1** and **liquid2**, with initial value of 10.5 each, which store
      the amount of these two liquids.
    - Two static `int` attributes called **MIX_1** and **MIX_2**, with initial values of 0 and 1, that cannot be changed
      later (using the final modifier). These are the numbers representing **liquid1** and **liquid2** attributes in the guide array.
    - An array of type `double` that will be different for each chemistry lab due to the different temperatures and
      air pressure.
    - Note that all attributes in this class should be private

- Constructors:
    - A constructor that accepts an array of type `double` as a parameter to initialize the **guide** attribute.
    - This constructor is accessible from other classes.

You need to add the following items:

- Methods:
    - A `mixFun` method which returns nothing and should be visible from another class. It should check if there is
      enough liquid left to make a reaction by finding the minimum amount need in the **guide** using the indexes **MIX_1** and
      **MIX_2**. If there is not enough liquid to make a reaction it should print
      `There's not enough ingredients to create the mixture`. If there is enough it should print `Mixing …`  and then
      decrease the amount of **liquid1** and **liquid2** by the minimum amount needed and then print `Mixing Successful`.