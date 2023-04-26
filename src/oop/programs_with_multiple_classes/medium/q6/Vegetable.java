package oop.programs_with_multiple_classes.medium.q6;

public class Vegetable {
    private boolean isSpoiled;

    public Vegetable(boolean b) {
        isSpoiled = b;
    }

    public void timePassed() {
        isSpoiled = true;
    }

}
