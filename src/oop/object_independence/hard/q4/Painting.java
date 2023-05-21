package oop.object_independence.hard.q4;

public class Painting {
    private String name;
    private String quality;

    public Painting(String n, String q) {
        name = n;
        quality = q;
    }

    public void setQuality(String q) {
        quality = q;
    }

    public void setName(String n) {
        name = n;
    }

    public String getQuality() {
        return quality;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "The item " + name + " is of " + quality + " quality";
    }
}
