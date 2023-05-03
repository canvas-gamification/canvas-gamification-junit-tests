# oop-creating_objects_from_classes-hard-q1

## Java questions

## Question Text

Given the dog class below, initialize a Dog with the following properties in the 
main method below:
- Name: "Piper"
- Age: 8
- Weight: 12.5

Then, call the `eat` method and the `bark` method on the created dog object.

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
