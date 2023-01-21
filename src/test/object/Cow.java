package test.object;

import java.io.Serializable;
import java.util.Iterator;

public class Cow extends Animal implements Serializable, Iterable<Cow> {
    String name;
    double weight;

    public Cow() {
        this.name = "John Cena";
        this.age = 666;
        this.weight = 99999.9999;
    }

    public Cow(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Iterator<Cow> iterator() {
        return null;
    }
}
