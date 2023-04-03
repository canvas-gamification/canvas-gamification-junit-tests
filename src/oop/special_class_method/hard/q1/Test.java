package oop.special_class_method.hard.q1;

public class Test {
    public static void main(String[] argos) {
        Bubble b = new Bubble(5);
        b.setSize(b.getSize() * 2);
        b.setIsPopped(true);
        System.out.println(b.toString());
    }
}
