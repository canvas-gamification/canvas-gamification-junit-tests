package oop.programs_with_multiple_classes.hard.q3;

public class TestFurniture {
    public static void main(String[] args) {
        Book b1 = new Book(1, "HardCover");
        Book b2 = new Book(1, "SoftCover");
        Bookcase bc1 = new Bookcase(20);
        System.out.println("Book 1: " + b1);
        System.out.println("Book 2: " + b2);
        System.out.println("Bookcase: " + bc1);
    }
}

