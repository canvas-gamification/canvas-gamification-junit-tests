package oop.special_class_method.medium.q14;

public class Water {
    private String quality;
    private double volume;

    public Water() {
        quality = "Good";
        volume = 1000.0;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double a) {
        this.volume = a;
    }

    public String toString() {
        return "The quality of the water is " + quality + " and the volume is " + volume;
    }
}

