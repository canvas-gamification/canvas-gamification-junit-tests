package oop.programs_with_interesting_classes.hard.q9;

public class Borrower {
    private String name;
    private String date;

    public Borrower(String n, String d) {
        name = n;
        date = d;
    }

    public String toString() {
        return name + " signed on " + date;
    }
}
