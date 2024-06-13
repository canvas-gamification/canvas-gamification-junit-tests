package oop.special_class_method.hard.q13;

public class Cup {
    private String colour;
    private double volume;
    private String liquid;

    public Cup(String colour, double volume, String liquid) {
        this.colour = colour;
        this.volume = volume;
        this.liquid = liquid;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setLiquid(String a) {
        this.liquid = a;
    }

    public String toString() {
        return "The " + colour + " Cup has " + volume + "ml of " + liquid;
    }
}

