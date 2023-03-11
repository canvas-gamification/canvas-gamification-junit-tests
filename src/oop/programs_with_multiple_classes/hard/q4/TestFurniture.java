package oop.programs_with_multiple_classes.hard.q4;

public class TestFurniture {
    public static void main(String[] args) {
        Book b1 = new Book(2005, "LeatherBound");
        Book b2 = new Book(2018, "EPub");
        Bookcase bc1 = new Bookcase(20, b1);
        System.out.println("Book 1: " + b1);
        System.out.println("Book 2: " + b2);
        System.out.println("Bookcase: " + bc1);
        System.out.println("Years since Book 1 was published: " + b1.determineTime());
        System.out.println("Years since Book 2 was published: " + b2.determineTime());
    }
}
