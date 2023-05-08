package oop.programs_with_multiple_classes.hard.q5;

public class Bookcase {
    private int sizeCapacity;
    private Book[] books;

    public Bookcase(int sizeCapacity, Book[] books) {
        this.sizeCapacity = sizeCapacity;
        this.books = books;
    }

    public String determineReplaced() {
        for (Book book : books) {
            if (book.determineTime() > 5)
                return "Time to buy a new book!";
        }
        return "You have enough new books!";
    }
}

