package oop.programs_with_multiple_classes.medium.q4;

public class TestVehicle {
    public static void main(String[] args) {
        Chassis c1 = new Chassis("Steel");
        Wheel w1 = new Wheel(5.5, "Milani");
        Wheel w2 = new Wheel(5.5, "Milani");
        Wheel w3 = new Wheel(6.9, "TRX");
        Wheel w4 = new Wheel(6.8, "RTX");
        System.out.println("Chassis: " + c1.toString());
        System.out.println("Wheel 1: " + w1.toString());
        System.out.println("Wheel 2: " + w2.toString());
        System.out.println("Wheel 3: " + w3.toString());
        System.out.println("Wheel 4: " + w4.toString());
    }
}

