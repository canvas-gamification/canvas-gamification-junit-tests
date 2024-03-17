package oop.programs_with_interesting_classes.easy.q4;

public class Tree {
    private String type;
    private double size;

    public Tree(String a, double b) {
        type = a;
        size = b;
    }

    public void gettingOlder() {
        setSize(getSize() + 4);
    }

    public String toString() {
        return "This is a " + type + " tree with " + size + " centimeters in diameter.";
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public void setType(String a) {
        type = a;
    }

    public void setSize(double a) {
        size = a;
    }
}
