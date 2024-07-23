package oop.programs_with_interesting_classes.medium.q6;

public class Horse {
    private String name;
    private double gateSpeed;
    private double acceleration;
    private double topSpeed;

    public Horse(String name, double gateSpeed, double acceleration, double topSpeed) {
        this.name = name;
        this.gateSpeed = gateSpeed;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
    }

    public String getName() {
        return this.name;
    }

    public double getGateSpeed() {
        return this.gateSpeed;
    }

    public double getAcceleration() {
        return this.acceleration;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public String toString() {
        return "Racer: " + name + ", starting speed of " + gateSpeed + " acceleration of " + acceleration + " and top speed of " + topSpeed;
    }

    public double completionTime(double distance) {
        int loopCount = 0;
        double distanceCovered = 0;
        while (distanceCovered < distance) {
            distanceCovered += Math.min(gateSpeed + (acceleration * loopCount), topSpeed) / 60;
            loopCount++;
        }
        double overrun = (distanceCovered - distance) / (Math.min(gateSpeed + (acceleration * loopCount - 1), topSpeed) / 60);

        return loopCount - overrun;
    }
}
