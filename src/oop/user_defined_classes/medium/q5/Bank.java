package oop.user_defined_classes.medium.q5;

public class Bank {
    private double fee;

    public Bank() {
        fee = 5.25;
    }

    public double increase(int months) {
        double futureFee = fee * (0.95 + months);
        return futureFee;
    }
}
