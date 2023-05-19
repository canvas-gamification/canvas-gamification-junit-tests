package oop.user_defined_classes.hard.q5;

public class Phone {
    private double width;
    private double height;

    public Phone(double w, double h) {
        width = w;
        height = h;
    }

    public double calcScreenSize() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
