package oop.programs_with_multiple_classes.medium.q7;

public class Cupboard {
    private int capacity;
    private boolean isFull;
    private Knife[] knifes;

    public Cupboard(int m, boolean b) {
        capacity = m;
        isFull = b;
        knifes = new Knife[capacity];
    }
}

