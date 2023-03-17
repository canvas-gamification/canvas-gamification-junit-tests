package oop.creating_objects_from_classes.hard.q3;

public class Tomato {

    private String name;
    private String usedFor;
    private String flavour;

    public Tomato() {
    }

    public Tomato(String name) {
        this.name = name;
    }

    public Tomato(String usedFor, String flavour, String name) {
        this.usedFor = usedFor;
        this.flavour = flavour;
        this.name = name;
    }

    public Tomato plantSeed(String[] names) {
        if (names.length == 1)
            return new Tomato(names[0]);
        else if (names.length == 3)
            return new Tomato(names[2], names[1], names[0]);
        else
            return new Tomato();
    }
}
