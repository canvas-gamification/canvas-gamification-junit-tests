package oop.programs_with_multiple_classes.hard.q5;

import java.time.Year;

public class Book {
    private int year;
    private String type;

    public Book(int year, String type) {
        this.year = year;
        this.type = type;
    }

    public int determineTime() {
        return Year.now().getValue() - year;
    }
}

