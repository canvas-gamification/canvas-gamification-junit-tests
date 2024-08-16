package oop.programs_with_interesting_classes.hard.q3;

public class Person {
    private String name;
    private int programming;
    private int communication;

    public Person(String n, int a, int b) {
        name = n;
        programming = a;
        communication = b;
    }

    public String toString() {
        return name + ": " + programming + ", " + communication + "\n";
    }

    public String getName() {
        return name;
    }

    public int getProgramming() {
        return programming;
    }

    public int getCommunication() {
        return communication;
    }
}
