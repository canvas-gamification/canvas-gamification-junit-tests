package oop.special_class_method.medium.q11;

public class Oven {
    private double currTemp;
    private double size;
    private String colour;

    public Oven(double ct, double s, String c) {
        currTemp = ct;
        size = s;
        colour = c;
    }

    public void setCurrTemp(double tmp) {
        currTemp = tmp;
    }

    public double getCurrTemp() {
        return currTemp;
    }

    public double getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public void powerDecrease() {
        currTemp = getCurrTemp() - 10;
    }

    public void powerIncrease() {
        currTemp = getCurrTemp() + 10;
    }

    public void changePower() {
        if (currTemp > 100)
            powerDecrease();
        else
            powerIncrease();
    }

    public String toString() {
        return "The " + colour + " Oven with size of " + size + " has the temperature of " + currTemp;
    }
}
