package oop.user_defined_classes.medium.q2;

public class Car {
    private String colour;
    private int horsePower;
    private int yearMade;

    public Car(String c, int hp, int ym) {
        colour = c;
        horsePower = hp;
        yearMade = ym;
    }

    public String printSpecs() {
        return "I am " + colour + " with " + horsePower + " horsepower";
    }
}
