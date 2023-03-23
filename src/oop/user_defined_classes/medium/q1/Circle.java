package oop.user_defined_classes.medium.q1;

public class Circle {
    private int position;
    private String colour;

    public Circle(int pos, String col) {
        position = pos;
        colour = col;
    }

    public void moveLocation() {
        position = (int) (Math.random() * 100);
    }
}
