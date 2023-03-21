package oop.programs_with_multiple_classes.medium.q2;

public class TestRoom {
    public static void main(String[] args) {
        Bed b1 = new Bed(400, true);
        Pillow p1 = new Pillow("Cotton", 2010);
        Pillow p2 = new Pillow("Air", 1995);
        System.out.println("Pillow1: " + p1.toString());
        System.out.println("Pillow2: " + p2.toString());
        System.out.println("Bed: " + b1.toString());
    }
}
