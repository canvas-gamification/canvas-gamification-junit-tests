package oop.creating_objects_from_classes.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

}

class Dog {
    private String name;
    private int age;
    private double weight;
    private static Dog dog;

    public Dog(String n, int a, double w) {
        if (dog == null) {
            name = n;
            age = a;
            weight = w;
            dog = this;
        } else {
            return dog;
        }
    }

    public void eat() {
        weight += 2.5;
    }

    public void bark() {
        System.out.println("Bark!");
    }
}
