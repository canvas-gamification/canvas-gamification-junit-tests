package oop.programs_with_multiple_classes.hard.q5;

public class Bookcase {
    private int sizeCapacity;
    private Book[] books;

    public Bookcase(int sizeCapacity, Book[] books) {
        this.sizeCapacity = sizeCapacity;
        if(sizeCapacity >= books.length) {
            this.books = books;
        }
        else {
            this.books = new Book[sizeCapacity];
            System.arraycopy(books, 0, this.books, 0, sizeCapacity);
        }
    }

    public String determineReplaced() {
        for (Book book : books) {
            if (book.determineTime() > 5)
                return "Time to buy a new book!";
        }
        return "You have enough new books!";
    }
}

