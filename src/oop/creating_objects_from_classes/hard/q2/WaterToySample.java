package oop.creating_objects_from_classes.hard.q2;

public class WaterToySample {
    String colour;
    double size;
    boolean inflated;

    public WaterToySample(String c, double s, boolean i) {
        colour = c;
        size = s;
        inflated = i;
    }

    public void inflate(){
        inflated = true;
    }

    public void throwInWater(){
        System.out.println("Splash!");
    }
}
