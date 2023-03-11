package oop.programs_with_multiple_classes.hard.q2;

public class TestFort {
    public static void main(String[] args) {
        Person ann = new Person(75.0);
        Person bob = new Person(63.0);
        Blanket fort = new Blanket("Large", 1500);
        System.out.println("Person 1: " + ann);
        System.out.println("Person 2: " + bob);
        System.out.println("Fort: " + fort);
    }
}

