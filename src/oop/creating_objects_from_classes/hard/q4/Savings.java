package oop.creating_objects_from_classes.hard.q4;

public class Savings {
    double initial;
    double bonus;
    /*
     * These values below are used to track the actions of the student in their test class. They track what values they
     * initialize the dog object to, and if they have called the methods they are supposed to.
     */
    private static Savings savings;
    private static boolean constructorCalled = false;
    private static double constructorInitial;
    private static boolean getTotalCalled = false;
    private static boolean getTotalCalledTwice = false;
    private static boolean recieveBonusCalled = false;

    public Savings(double initial) {
        constructorCalled = true;
        this.initial = initial;
        bonus = Math.random()*200;
        if(savings == null){
            constructorInitial = initial;
            savings = this;
        }
    }

    public double getTotal(){
        if(getTotalCalled){
            getTotalCalledTwice = true;
        }
        getTotalCalled = true;
        return initial + bonus;
    }

    public double receiveBonus(){
        recieveBonusCalled = true;
        return bonus += Math.random()*200;
    }

    public static Savings getSavings() {
        return savings;
    }

    public static boolean isConstructorCalled() {
        return constructorCalled;
    }

    public static double getConstructorInitial() {
        return constructorInitial;
    }

    public static boolean isGetTotalCalled() {
        return getTotalCalled;
    }

    public static boolean isGetTotalCalledTwice() {
        return getTotalCalledTwice;
    }

    public static boolean isRecieveBonusCalled() {
        return recieveBonusCalled;
    }
}
