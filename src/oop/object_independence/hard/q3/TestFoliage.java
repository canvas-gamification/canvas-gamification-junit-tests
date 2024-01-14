package oop.object_independence.hard.q3;

public class TestFoliage {
    public static void main(String[] args) {
        Tree t1 = new Tree(true, 50.5);
        Tree t2 = new Tree(false, 20.4);
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        t1.deforestation();
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
