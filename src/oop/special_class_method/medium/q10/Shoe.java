package oop.special_class_method.medium.q10;

public class Shoe {
    private int size;
    private String colour;

    public Shoe(int sz, String c) {
        size = sz;
        colour = c;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int a) {
        size = a;
    }

    public void setColour(String a) {
        colour = a;
    }

    public String getColour() {
        return colour;
    }

    public String toString() {
        String str = "The size of this shoe is " + size + " and its colour is " + colour;
        return str;
    }
}
