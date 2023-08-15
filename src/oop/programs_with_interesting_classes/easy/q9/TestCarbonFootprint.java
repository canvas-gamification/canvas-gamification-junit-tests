package oop.programs_with_interesting_classes.easy.q9;

public class TestCarbonFootprint {
    public static void main(String[] args) {
        Activity a1 = new Activity("Car", 30.5);
        Activity a2 = new Activity("Bicycle", 10);
        Activity a3 = new Activity("Bus", 1.2);
        Activity[] activityList = {a1, a2, a3};
        double highestRate = 0;
        String worstActivity = "";
        for (int i = 0; i < activityList.length; i++) {
            if (activityList[i].getDailyEmissionRate() > highestRate) {
                highestRate = activityList[i].getDailyEmissionRate();
                worstActivity = activityList[i].getType();
            }
        }
        System.out.println("The activity that generates the most greenhouse gases is " + worstActivity);
    }
}
