package oop.special_class_method.hard.q5;

public class Road {
    private int lanes;
    private String typeOfRoad;
    private int maxCapacity;

    public Road(int a, String b, int c) {
        lanes = a;
        typeOfRoad = b;
        maxCapacity = c;
    }

    public String toString() {
        return "The Road instance lanes is " + lanes + ", its typeOfRoad is " + typeOfRoad + ", and its maxCapacity is " + maxCapacity + ".";
    }

    public void setLanes(int a) {
        lanes = a;
    }

    public int getLanes() {
        return lanes;
    }

    public void setTypeOfRoad(String a) {
        typeOfRoad = a;
    }

    public String getTypeOfRoad() {
        return typeOfRoad;
    }

    public void setMaxCapacity(int a) {
        maxCapacity = a;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}

