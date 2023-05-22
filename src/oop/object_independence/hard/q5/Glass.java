package oop.object_independence.hard.q5;

public class Glass {
    private String condition;
    public boolean isBroken;
    private double weight;

    public Glass(String s, boolean b, double w) {
        condition = s;
        isBroken = b;
        weight = w;
    }

    public void broken() {
        isBroken = true;
    }

    public void fix() {
        isBroken = false;
    }

    public String toString() {
        return "The item is " + condition + ", and its weight is " + weight + " and is it broken? " + isBroken;
    }
}

