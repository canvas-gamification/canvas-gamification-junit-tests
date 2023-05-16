package oop.special_class_method.hard.q6;

public class Car {
    private double topSpeed;
    private String type;

    public Car() {
        topSpeed = 180;
        type = null;
    }

    public Car(double a, String b) {
        topSpeed = a;
        type = b;
    }

    public String toString() {
        return "Car{topSpeed: " + topSpeed + ", type: " + type + "}";
    }

    public void setTopSpeed(double a) {
        topSpeed = a;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setType(String a) {
        type = a;
    }

    public String getType() {
        return type;
    }
}

