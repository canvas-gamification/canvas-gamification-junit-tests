package oop.object_interactions.medium.q6;

public class TestBooking {
    public static void main(String[] args) {
        Airplane first = new Airplane(12, 20);
        Airplane second = new Airplane(6);
        second.transferPassengers(first);
        Airplane third = new Airplane(4);
        third.transferPassengers(first);
        System.out.println("The first ride: " + first.toString());
        System.out.println("The second ride: " + second.toString());
        System.out.println("The third ride: " + third.toString());
    }
}
