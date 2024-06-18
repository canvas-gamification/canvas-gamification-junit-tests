# oop-creating_objects_from_classes-hard-q3

## Java questions

## Question Text

Suppose you have defined a `Tomato` class to model your tomato plants, and now you want to test it to make sure that it 
works. Given the tomato class below, create a test class called `TomatoTest` with a main method and initialize four 
`Tomato` objects. The first tomato should be initialized using the default constructor, with no attributes. The second
tomato should be initialized just with the attribute:
-Type: cherry
The third should be initialized with the attributes:
-Type: plum
-Nickname: Sherry
The last should be initialized using the `produceSeed` method with:
-Nickname: Delilah 
and type will be the same as the tomato it came from. 

Note: You do not need to place the tomato class in your submission code, the website will handle this for you. It is just
for you to reference.

### Tomato Class:

```java
public class Tomato {
    private String type;
    private String nickname;

    public Tomato() {
    }

    public Tomato(String t) {
        type = t;
    }

    public Tomato(String t, String n) {
        type = t;
        nickname = n;
    }

    public Tomato produceSeed(String[] parameters) {
        if (parameters.length == 1)
            return new Tomato(parameters[0]);
        else if (parameters.length == 2)
            return new Tomato(parameters[0], parameters[1]);
        else
            return new Tomato();
    }
}
```