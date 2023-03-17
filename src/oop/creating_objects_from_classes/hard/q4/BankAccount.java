package oop.creating_objects_from_classes.hard.q4;

public class BankAccount {
    public Savings startInvestment() {
        double initial = Math.random() * 200;
        return new Savings(initial, 0);
    }
}
