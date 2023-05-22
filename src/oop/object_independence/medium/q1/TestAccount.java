package oop.object_independence.medium.q1;

public class TestAccount {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(100.0, 123456789);
        BankAccount b2 = new BankAccount(0, 123456790);
        b2.deposit(400);
        b1.listBalance();
        b2.listBalance();
    }
}
