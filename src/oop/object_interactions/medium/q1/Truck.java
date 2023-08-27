package oop.object_interactions.medium.q1;

public class Truck {
    private double currentWeight;

    public Truck(double w) {
        currentWeight = w;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double w) {
        currentWeight = w;
    }

    public void splitLoad(Truck heavy) {
        double totalWeight = heavy.getCurrentWeight() + getCurrentWeight();
        heavy.setCurrentWeight(totalWeight / 2);
        setCurrentWeight(totalWeight / 2);
    }

    public String toString() {
        return "\tMy weight is: " + currentWeight;
    }
}
