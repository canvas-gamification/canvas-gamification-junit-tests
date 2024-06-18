package oop.programs_with_interesting_classes.easy.q9;

public class Activity {
    private String type;
    private double dailyEmissionRate;

    public Activity(String type, double dailyEmissionRate) {
        this.type = type;
        this.dailyEmissionRate = dailyEmissionRate;
    }

    public String getType() {
        return type;
    }

    public double getDailyEmissionRate() {
        return dailyEmissionRate;
    }
}

