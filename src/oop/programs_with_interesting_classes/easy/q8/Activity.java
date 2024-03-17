package oop.programs_with_interesting_classes.easy.q8;

public class Activity {
    private String name;
    private double consumptionRate;
    private int duration;

    public Activity(String name, double consumptionRate, int duration) {
        this.name = name;
        this.consumptionRate = consumptionRate;
        this.duration = duration;
    }

    public double usageCalculator() {
        return consumptionRate * duration;
    }

    public String getName() {
        return name;
    }
}

