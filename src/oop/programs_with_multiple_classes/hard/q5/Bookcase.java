package oop.programs_with_multiple_classes.hard.q5;

public class Bookcase {
    private int sizeCapacity;
    private Book b1;

    public Bookcase(int sizeCapacity, Book b1) {
        this.sizeCapacity = sizeCapacity;
        this.b1 = b1;
    }

    public String determineReplaced() {
        if (b1.determineTime() > 5)
            return "Time to buy a new book";
        else
            return "The book will still last";
    }

    @Override
    public String toString() {
        return "Bookcase{" +
                "sizeCapacity=" + sizeCapacity +
                ", b1=" + b1 +
                '}';
    }
}

