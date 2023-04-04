package oop.programs_with_multiple_classes.medium.q10;

public class Vegetable {
    private boolean isSpoiled;
    private double weight;
    private String countryOfOrigin;

    public Vegetable(boolean b, double d, String s) {
        isSpoiled = b;
        weight = d;
        countryOfOrigin = s;
    }

    public void eating() {
        weight -= 0.5;
    }

    public String toString() {
        return "Vegetable{isSpoiled = " + isSpoiled + ", weight = " + weight + ", countryOfOrigin = " + countryOfOrigin + "}";
    }
}
