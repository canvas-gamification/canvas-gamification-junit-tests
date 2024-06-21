package oop.special_class_method.medium.q9;

public class Car {
    private String maker;
    private double topSpeed;

    public Car(String m, double ts) {
        maker = m;
        topSpeed = ts;
    }

    public String getMaker() {
        return maker;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public String toString(){
        return "I was made by " + maker + " with top speed of " + topSpeed;
    }
}
