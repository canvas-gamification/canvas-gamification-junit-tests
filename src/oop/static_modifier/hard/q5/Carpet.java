package oop.static_modifier.hard.q5;

public class Carpet {
    private static double materialAreaAvailable = 300;
    private double houseArea;

    public Carpet(double area) {
        houseArea = area;
    }

    public boolean canCompleteFlooring() {
        if (materialAreaAvailable >= houseArea) {
            materialAreaAvailable -= houseArea;
            return true;
        } else
            return false;
    }
}
