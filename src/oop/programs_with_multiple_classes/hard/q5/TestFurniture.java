package oop.programs_with_multiple_classes.hard.q5;

public class TestFurniture {
    public static void main(String[] args) {
        Book b1 = new Book(2005, "HardCover");
        Book b2 = new Book(2019, "SoftCover");
        Bookcase bc1 = new Bookcase(40, b1);
        Bookcase bc2 = new Bookcase(40, b2);
        bc1.determineReplaced();
        bc2.determineReplaced();
        System.out.println("Book 1: " + b1);
        System.out.println("Book 2: " + b2);
        System.out.println("Bookcase 1: " + bc1);
        System.out.println("Bookcase 2: " + bc2);
        System.out.println("Do I need a new book for Bookcase 1? " + bc1.determineReplaced());
        System.out.println("Do I need a new book for Bookcase 2? " + bc2.determineReplaced());
    }
}
