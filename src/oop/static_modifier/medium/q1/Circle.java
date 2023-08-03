package oop.static_modifier.medium.q1;

public class Circle {
    private static int counter = 0;
    private double radius;

    public Circle(double r) {
        radius = r;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
