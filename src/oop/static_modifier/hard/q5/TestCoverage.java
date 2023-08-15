package oop.static_modifier.hard.q5;

public class TestCoverage {
    public static void main(String[] args) {
        double[] houses = {126, 133, 81, 100, 90.25, 156.25};
        int count = 0;
        for (int i = 0; i < houses.length; i++) {
            Carpet obj = new Carpet(houses[i]);
            if (obj.canCompleteFlooring())
                count++;
            else
                break;
        }
        System.out.println("There is enough material for " + count + " houses");
    }
}
