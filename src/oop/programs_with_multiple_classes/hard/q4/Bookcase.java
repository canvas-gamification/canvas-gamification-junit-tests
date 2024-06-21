package oop.programs_with_multiple_classes.hard.q4;

public class Bookcase {
    private int sizeCapacity;
    private Book[] books;

    public Bookcase(int sizeCapacity, Book[] books) {
        this.sizeCapacity = sizeCapacity;
        this.books = books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void sellBook(int index) {
        if (books[index].howManyYears() >= 20) {
            System.out.println("No, this book is precious to me.");
        } else {
            books[index] = null;
        }
    }
}
