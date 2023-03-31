package oop.programs_with_multiple_classes.medium.q5;

public class TestWorkSetUp {
    public static void main(String[] args) {
        Monitor m1 = new Monitor(21);
        Monitor m2 = new Monitor(27);
        Desk d1 = new Desk("Milani");
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(d1.toString());
    }
}
