package oop.static_modifier.hard.q2;

public class Test {
    public static void main(String[] args) {
        Lightbulb l1 = new Lightbulb("LED");
        Lightbulb l2 = new Lightbulb("LCD");
        Lightbulb l3 = new Lightbulb("Halogen");
        l1.setVoltage(150);
        System.out.println(l1);
        l1.setVoltage(200);
        System.out.println(l2);
        l1.setVoltage(300);
        System.out.println(l3);
    }
}

