package oop.object_independence.medium.q1;

public class BankAccount {
    private double currentBalance;
    private long accountNumber;

    public BankAccount(double amount, long num) {
        currentBalance = amount;
        accountNumber = num;
    }

    public void deposit(double amount) {
        currentBalance += amount;
    }

    public void withdraw(double amount) {
        if (currentBalance >= amount)
            currentBalance -= amount;
    }

    public void listBalance() {
        System.out.println("Account No. " + accountNumber + " currently has a balance of $" + currentBalance);
    }
}
