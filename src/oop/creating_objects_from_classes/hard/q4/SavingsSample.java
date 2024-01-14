package oop.creating_objects_from_classes.hard.q4;

public class SavingsSample {
    double initial;
    double bonus;

    public SavingsSample(double initial) {
        this.initial = initial;
        bonus = Math.random()*200;
    }

    public double getTotal(){
        return initial + bonus;
    }

    public double receiveBonus(){
        return bonus += Math.random()*200;
    }
}
