package oop.special_class_method.hard.q11;

public class Alien {
    private int numEyes;
    private String colour;

    public Alien(int e, String c) {
        numEyes = e;
        colour = c;
    }

    public int getNumEyes() {
        return numEyes;
    }

    public String getColour() {
        return colour;
    }

    public String toString() {
        return "The " + colour + " Alien has " + numEyes + " eyes";
    }
}
