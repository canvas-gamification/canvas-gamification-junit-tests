package oop.special_class_method.hard.q1;

public class Bubble {
    private double size;
    private boolean isPopped;

    public Bubble(double a) {
        size = a;
        isPopped = false;
    }

    public String toString() {
        String out = "size: " + size + ", isPopped: " + isPopped;
        return out;
    }

    public void setSize(double a) {
        size = a;
    }

    public double getSize() {
        return size;
    }

    public void setIsPopped(boolean a) {
        isPopped = a;
    }

    public boolean getIsPopped() {
        return isPopped;
    }
}

