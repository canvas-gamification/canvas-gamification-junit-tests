# oop-creating_objects_from_classes-hard-q1

## Java questions

## Question Text

Suppose you have defined a `Dog` class to model your pet, and now you want to test it to make sure that it works. Given 
the dog class below, create a test class called `DogTest` with a main method and initialize a `Dog` object with the 
following attributes:
- Name: "Piper"
- Age: 8
- Weight: 12.5

Then, call the `eat` method and the `bark` method on the created dog object. The result from doing this should be 
the printing of the `String` "Bark!".

Note: You do not need to place the dog class in your submission code, the website will handle this for you. It is just
for you to reference.

### Dog Class:

```java
public class Dog {
    private String name;
    private int age;
    private double weight;

    public Dog(String n, int a, double w) {
        name = n;
        age = a;
        weight = w;
    }

    public void eat() {
        weight += 2.5;
    }

    public void bark() {
        System.out.println("Bark!");
    }
}
```
