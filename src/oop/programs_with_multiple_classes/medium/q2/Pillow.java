package oop.programs_with_multiple_classes.medium.q2;

public class Pillow {
    private String filling;
    private int yearMade;

    public Pillow(String f, int ym) {
        filling = f;
        yearMade = ym;
    }

    public String toString() {
        return "Pillow{filling = " + filling + ", yearMade = " + yearMade + "}";
    }
}
