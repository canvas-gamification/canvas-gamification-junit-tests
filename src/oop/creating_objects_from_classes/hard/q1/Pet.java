package oop.creating_objects_from_classes.hard.q1;

public class Pet {
    public Dog makePet(String name) {
        return new Dog(name);
    }
}
