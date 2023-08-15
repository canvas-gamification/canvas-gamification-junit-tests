package oop.static_modifier.hard.q4;

public class Bed {
    public static int woodBeams = 100;
    private int numBeams;

    public Bed(int nb) {
        numBeams = nb;
    }

    public boolean makeFurniture() {
        if (numBeams > woodBeams)
            return false;
        else {
            woodBeams -= numBeams;
            return true;
        }
    }
}

