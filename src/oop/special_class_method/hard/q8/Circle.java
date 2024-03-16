package oop.special_class_method.hard.q8;

public class Circle {
    private double radius;
    private String colour;

    public Circle(double a, String b) {
        radius = a;
        colour = b;
    }

    public String toString() {
        return "I have a " + radius + " radius and my colour is " + colour;
    }

    public void setRadius(double a) {
        radius = a;
    }

    public double getRadius() {
        return radius;
    }

    public void setColour(String a) {
        colour = a;
    }

    public String getColour() {
        return colour;
    }
}
