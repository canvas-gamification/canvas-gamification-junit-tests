package oop.object_interactions.medium.q5;

public class TestTransplant {
    public static void main(String[] args) {
        Person tom = new Person("Tom", 2);
        Person jim = new Person("Jim", 0);
        System.out.println(tom.toString());
        System.out.println(jim.toString());
        jim.receiveDonation(tom);
        System.out.println(tom.toString());
        System.out.println(jim.toString());
    }
}

