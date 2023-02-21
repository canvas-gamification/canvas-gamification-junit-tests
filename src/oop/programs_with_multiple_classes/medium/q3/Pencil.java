package oop.programs_with_multiple_classes.medium.q3;

public class Pencil {
    private int hardness;
    private boolean isForSchool;

    public Pencil(int hb, boolean school) {
        hardness = hb;
        isForSchool = school;
    }

    public String toString() {
        return "Pencil{hardness = " + hardness + ", isForSchool = " + isForSchool + "}";
    }
}
