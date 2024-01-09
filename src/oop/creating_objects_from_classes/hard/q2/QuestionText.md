# oop-creating_objects_from_classes-hard-q2

## Question Text

Suppose you have defined a `WaterToy` class, and now you want to define a `SummerFun` class. In the `SummerFun` class, you need to define
a method called `inflateToy` that takes a String as input for a name and returns a **WaterToy** object. Use the constructor in
the provided `WaterToy` class to do this.

## Java questions

## Question Text

Suppose you have defined a `WaterToy` class to model your pool toys, and now you want to test it to make sure that it 
works. Given the water toy class below, create a test class called `SummerFun` with a main method and initialize a 
`WaterToy` object with the following attributes:
- Colour: "yellow"
- size: 5.2
- inflated: false

Then, call the `inflate` method and the `throwInWater` method on the created water toy object. The result from doing 
this should be the printing of the `String` "Splash!".

Note: You do not need to place the water toy class in your submission code, the website will handle this for you. It 
is just for you to reference.

### Dog Class:

```java
public class WaterToy {
    String colour;
    double size;
    boolean inflated;

    public WaterToy(String c, double s, boolean i) {
        colour = c;
        size = s;
        inflated = i;
    }

    public void inflate(){
        inflated = true;
    }

    public void throwInWater(){
        System.out.println("Splash!");
    }
}
```