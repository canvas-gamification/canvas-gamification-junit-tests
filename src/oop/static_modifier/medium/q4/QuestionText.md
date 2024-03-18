# oop-static_modifier-medium-q4

- Question Type: Java

## Question Text

You want to make a program for the chemistry labs in a school that are making an experiment with household liquids.
Lots of different household items can make fun chemistry experiments. Make a Java program called **ChemistryLab**  with the requirements below:

### ChemistryLab Class

Your `ChemistryLab` class already the following items:

- Attributes:
    - Two static `double` attributes called **liquid1** and **liquid2**, with initial value of 10.5 each, which store
      the amount of these two liquids.
    - An array of type `double` called guide. Due to environmental factors like air pressure, this array will be different for each chemistry lab. It stores the amount of each liquid needed to conduct a reaction in that lab.
    - Two **static** **final** `int` attributes called **MIX_1** and **MIX_2**, with initial values of 0 and 1, that cannot be changed. These corespond to the values in guide of how much of **liquid1** and **liquid2** is needed for a reaction.
    - Note that all attributes in this class should be private

- Constructors:
    - A constructor that accepts an array of type `double` as a parameter to initialize the **guide** attribute.
    - This constructor is accessible from other classes.

You need to add the following items:

- Methods:
    - A `mixFun` method which returns nothing and should be visible from another class. It should check if there is
      enough liquid left to make a reaction by finding the minimum amount needed in the **guide** using the indexes **MIX_1** and
      **MIX_2**. If there is not enough liquid to make a reaction it should print
      `There's not enough ingredients to create the mixture`. If there is enough it should print `Mixing …`  and then
      decrease the amount of **liquid1** and **liquid2** by the minimum amount needed and then print `Mixing Successful`.
    - Note that **MIX_1** and **MIX_2** respectively correspond to **liquid1** and **liquid2**