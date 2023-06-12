package oop.object_interactions.medium.q1;

public class TestTruck {
    public static void main(String[] args) {
        Truck t1 = new Truck(450.8);
        Truck t2 = new Truck(0);
        System.out.println("Before split: ");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        t2.splitLoad(t1);
        System.out.println("After split: ");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
