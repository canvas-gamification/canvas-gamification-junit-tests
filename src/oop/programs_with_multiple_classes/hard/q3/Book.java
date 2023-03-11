package oop.programs_with_multiple_classes.hard.q3;

public class Book {
    private int count;
    private String type;

    public Book(int count, String type) {
        this.count = count;
        this.type = type;
    }

    public String toString() {
        return "Book{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }
}
