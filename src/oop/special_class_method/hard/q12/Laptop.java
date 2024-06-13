package oop.special_class_method.hard.q12;

public class Laptop {
    private int yearMade;
    private String colour;

    public Laptop(int yearMade, String texture) {
        this.yearMade = yearMade;
        this.colour = texture;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void setColour(String t) {
        colour = t;
    }

    public int getYearMade() {
        return yearMade;
    }

    public String getColour() {
        return colour;
    }

    public void addSticker(String s) {
        colour += " and " + s;
    }
}

