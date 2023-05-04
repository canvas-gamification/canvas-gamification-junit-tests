package oop.programs_with_multiple_classes.medium.q4;

public class Wheel {
    private double durability;
    private String manufacturer;

    public Wheel(double d, String m) {
        if(d > 0)
            durability = d;
        else
            durability = 0;
        manufacturer = m;
    }

}
