package oop.special_class_method.hard.q2;

public class Glasses {
    private double size;
    private String type;

    public Glasses(double a, String b) {
        size = a * 10;
        type = b;
    }

    public String toString() {
        return "Glasses{size: " + size + ", type: " + type + "}";
    }

    public void setSize(double a) {
        size = a;
    }

    public double getSize() {
        return size;
    }

    public void setType(String a) {
        type = a;
    }

    public String getType() {
        return type;
    }
}

