package oop.programs_with_multiple_classes.medium.q3;

public class TestPencilCase {
    public static void main(String[] args) {
        Pencil p1 = new Pencil(2, false);
        Pencil p2 = new Pencil(1, true);
        Eraser e1 = new Eraser(10.5);
        Eraser e2 = new Eraser(4.3);
        System.out.println("Pencil 1: " + p1.toString());
        System.out.println("Pencil 2: " + p2.toString());
        System.out.println("Eraser 1: " + e1.toString());
        System.out.println("Eraser 2: " + e2.toString());
    }
}
