package oop.creating_objects_from_classes.hard.q4;

public class BankAccount {
    public static void main(String[] args) {
        Savings s = new Savings(500.32);
        System.out.println("Balance: " + s.getTotal());
        s.receiveBonus();
        System.out.println("Balance: " + s.getTotal());
    }
}
