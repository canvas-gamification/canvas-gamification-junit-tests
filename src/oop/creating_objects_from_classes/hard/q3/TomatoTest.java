package oop.creating_objects_from_classes.hard.q3;

public class TomatoTest {
    public static void main(String[] args) {
        Tomato t1 = new Tomato();
        Tomato t2 = new Tomato("cherry");
        Tomato t3 = new Tomato("plum", "Sherry");
        Tomato t4 = t2.produceSeed("Delilah");
    }
}
