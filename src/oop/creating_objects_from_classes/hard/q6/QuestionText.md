# oop-creating_objects_from_classes-hard-q6

(instead of Martini: Margarita, Mojito, Cosmopolitan, Negroni, MoscowMule, BrownCow, Manhattan, Spritz, Mimosa, 
Daiquiri, LongIslandIcedTea, WhiteLady, ElDiablo, Zombie, IrishCoffee, Sidecar, PinaColada, Bellini, French75, Gimlet, 
BloodyMary, WhiskeySour, ShirleyTemple, GinAndTonic)

## Java questions

## Question Text

Suppose you have defined a `Martini` class to model your drink, and now you want to test it to make sure that it works. 
Given the martini class below, create a test class called `OrderDrink` with a main method and initialize a `Martini` 
object with the following attributes:
- ingredients: "vodka", "lemon juice", "syrup", "triple sec"
- percentAlcohol: 15

Then, call the `mix` method and the `detectFlavour` method on the created martini object. The result from doing this 
should be the printing of the `String` "I detect " followed by a randomly chosen ingredient from the ingredients array.

Note: You do not need to place the martini class in your submission code, the website will handle this for you. It is 
just for you to reference.

### Martini Class:

```java
public class Martini {
    private String[] ingredients;
    private double percentAlcohol;
    private boolean mixed;

    public Martini(String[] i, double p){
        ingredients = i;
        percentAlcohol = p;
        mixed = false;
    }

    public void mix(){
        mixed = true;
    }

    public void detectFlavour(){
        String flavour = ingredients[(int)(Math.random()*ingredients.length)];
        System.out.println("I detect " + flavour);
    }
}
```
