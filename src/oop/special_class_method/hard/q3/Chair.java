package oop.special_class_method.hard.q3;

public class Chair {
    private double size;
    private String softness;

    public Chair(double a, String b) {
        size = a;
        softness = b;
    }

    public String toString() {
        return "This Chair's size is " + size + ", and it's softness is " + softness;
    }

    public void setSize(double a) {
        size = a;
    }

    public double getSize() {
        return size;
    }

    public void setSoftness(String a) {
        softness = a;
    }

    public String getSoftness() {
        return softness;
    }
}

