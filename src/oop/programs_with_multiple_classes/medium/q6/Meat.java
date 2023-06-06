package oop.programs_with_multiple_classes.medium.q6;

public class Meat {
    private boolean isSpoiled;

    public Meat(boolean b) {
        isSpoiled = b;
    }

    public void timePassed() {
        isSpoiled = true;
    }

}
