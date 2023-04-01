package oop.programs_with_multiple_classes.medium.q7;

public class Knife {
    private int size;
    private String materialType;

    public Knife(int m, String s) {
        size = m;
        materialType = s;
    }

    public String toString() {
        return "Knife{size = " + size + ", materialType = " + materialType + "}";
    }
}
