package oop.programs_with_multiple_classes.hard.q4;

public class Bookcase {
    private int sizeCapacity;
    private Book b1;

    public Bookcase(int sizeCapacity, Book b1) {
        this.sizeCapacity = sizeCapacity;
        this.b1 = b1;
    }

    @Override
    public String toString() {
        return "Bookcase{" +
                "sizeCapacity=" + sizeCapacity +
                ", b1=" + b1 +
                '}';
    }
}
