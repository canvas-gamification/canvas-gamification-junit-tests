package oop.programs_with_multiple_classes.medium.q2;

public class Bed {
    private int weightCapacity;
    private boolean isComfy;

    public Bed(int wc, boolean ic) {
        weightCapacity = wc;
        isComfy = ic;
    }

    public String toString() {
        return "Bed{isComfy = " + isComfy + ", weightCapacity = " + weightCapacity + "}";
    }
}
