package oop.static_modifier.hard.q7;

public class Taxes {
    private static int GST = 5;
    private static double PST = 7;

    public static void changeLocation(String province) {
        switch (province) {
            case "Ontario" -> {
                GST = 13;
                PST = 0;
            }
            case "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Prince Edward Island" -> {
                GST = 15;
                PST = 0;
            }
            default -> {
                GST = 5;
                switch (province) {
                    case "Saskatchewan" -> PST = 6;
                    case "Quebec" -> PST = 9.975;
                    case "Manitoba", "British Columbia" -> PST = 7;
                    default -> PST = 0;
                }
            }
        }
    }

    public static double calculateTotal(double cost) {
        double taxPct = (GST + PST) / 100.0;
        return cost * ( 1 + taxPct );
    }
}
