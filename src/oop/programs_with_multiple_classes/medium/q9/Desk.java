package oop.programs_with_multiple_classes.medium.q9;

public class Desk {
    private String materialType;
    private int yearsOld;
    private Monitor[] monitors;

    public Desk(String m, int i) {
        materialType = m;
        yearsOld = i;
        monitors = new Monitor[3];
    }
}
