package oop.programs_with_interesting_classes.easy.q8;

public class TestWaterUsage {
    public static void main(String[] args) {
        Activity a1 = new Activity("Shower", 0.5, 30);
        Activity a2 = new Activity("Cooking", 1, 60);
        Activity a3 = new Activity("Watering Plants", 2, 120);
        double dailyUsage = 0;
        dailyUsage += a1.usageCalculator();
        dailyUsage += a2.usageCalculator();
        dailyUsage += a3.usageCalculator();
        System.out.println("The total water usage is " + dailyUsage);
        double highestAmount = a1.usageCalculator();
        String worstActivity = a1.getName();
        if (a2.usageCalculator() > highestAmount) {
            highestAmount = a2.usageCalculator();
            worstActivity = a2.getName();
        }
        if (a3.usageCalculator() > highestAmount) {
            worstActivity = a3.getName();
        }
        System.out.println("The activity that uses the most water is " + worstActivity);
    }
}

