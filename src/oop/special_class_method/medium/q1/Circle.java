package oop.special_class_method.medium.q1;

public class Circle {
    private double size;

    public Circle(double sz) {
        size = sz;
    }

    public void setSize(double sz) {
        size = sz;
    }

    public double getSize() {
        return size;
    }

    public String toString() {
        return "My size is " + size;
    }
}
