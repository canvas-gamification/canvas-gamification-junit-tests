package oop.creating_objects_from_classes.hard.q1;

public class DogSample {
    private String name;
    private int age;
    private double weight;

    public DogSample(String n, int a, double w) {
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
