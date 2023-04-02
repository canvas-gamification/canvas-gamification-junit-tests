package oop.programs_with_multiple_classes.medium.q9;

public class Desk {
    private String materialType;
    private int yearsOld;

    public Desk(String m, int i) {
        materialType = m;
        yearsOld = i;
    }

    public String toString() {
        return "Desk{materialType = " + materialType + ", yearsOld = " + yearsOld + "}";
    }
}
