package oop.programs_with_interesting_classes.hard.q7;

import java.util.Arrays;
import java.util.Random;

public class Country {
    private Animal[] localAnimals;
    private String name;

    public Country(String n, Animal[] a) {
        name = n;
        localAnimals = a;
    }

    public void setLocalAnimals(Animal[] a) {
        localAnimals = a;
    }

    public Animal getRandomAnimal() {
        Random r = new Random();
        return localAnimals[r.nextInt(localAnimals.length)];
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " has: " + Arrays.toString(localAnimals);
    }
}
