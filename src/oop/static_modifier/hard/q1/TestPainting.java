package oop.static_modifier.hard.q1;

public class TestPainting {
    public static void main(String[] args) {
        Fence f1 = new Fence("Red");
        Fence f2 = new Fence("Green");
        Fence f3 = new Fence("Yellow");
        f1.paintColour("Brown", 25.5);
        System.out.println(f1);
        f2.paintColour("Brown", 68.8);
        System.out.println(f2);
        f3.paintColour("Brown", 38.5);
        System.out.println(f3);
    }
}
