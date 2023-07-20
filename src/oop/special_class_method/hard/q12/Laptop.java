package oop.special_class_method.hard.q12;

public class Laptop {
    private int yearMade;
    private String texture;

    public Laptop(int yearMade, String texture) {
        this.yearMade = yearMade;
        this.texture = texture;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void setTexture(String t) {
        texture = t;
    }

    public int getYearMade() {
        return yearMade;
    }

    public String getTexture() {
        return texture;
    }
}

