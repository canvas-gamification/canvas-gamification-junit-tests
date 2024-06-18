package oop.special_class_method.hard.q7;

public class PiggyBank {
    private double money;
    private int time;

    public PiggyBank() {
        money = 0;
        time = 0;
    }

    public PiggyBank(double d, int i) {
        money = d;
        time = i;
    }

    public String toString() {
        return "I have " + money + " dollars in me after " + time + " days.";
    }

    public void setMoney(double a) {
        money = a;
    }

    public double getMoney() {
        return money;
    }

    public void setTime(int a) {
        time = a;
    }

    public int getTime() {
        return time;
    }

}
