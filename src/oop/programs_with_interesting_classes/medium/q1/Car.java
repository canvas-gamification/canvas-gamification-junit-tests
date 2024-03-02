package oop.programs_with_interesting_classes.medium.q1;

import java.util.Arrays;

public class Car {
    private String name;
    private double speed;
    private String[] parts;

    public Car(String nm, double spd) {
        name = nm;
        parts = new String[]{"Wheels", "Chassis", "Steering", "BodyKit", "Windows", "Doors", "Seats"};
        speed = spd;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }

    public String[] getParts() {
        return parts;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String nm) {
        name = nm;
    }

    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", parts=" + Arrays.toString(parts) +
                '}';
    }
}
