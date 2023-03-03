package oop.programs_with_multiple_classes.hard.q1;

public class TestGroup {
    public static void main(String[] args) {
        Circus funGroup = new Circus(100);
        Member owner = new Member("Juggler");
        Member juggler = new Member("Tightrope Walker");
        System.out.println("Circus: " + funGroup);
        System.out.println("Member 1: " + owner);
        System.out.println("Member 2: " + juggler);
    }
}
