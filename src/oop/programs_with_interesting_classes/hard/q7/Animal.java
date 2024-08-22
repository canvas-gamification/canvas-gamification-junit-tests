package oop.programs_with_interesting_classes.hard.q7;

public class Animal {
    private String name;
    private String sound;

    public Animal(String n, String s) {
        name = n;
        sound = s;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public String toString() {
        return name + " makes the noise " + sound;
    }
}
