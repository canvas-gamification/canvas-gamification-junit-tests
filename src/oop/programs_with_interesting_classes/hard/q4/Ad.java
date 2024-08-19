package oop.programs_with_interesting_classes.hard.q4;

public class Ad {
    private String street;
    private int numberOfRooms;
    private double monthlyRent;

    public Ad(String a, int b, double d) {
        street = a;
        numberOfRooms = b;
        monthlyRent = d;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String toString() {
        String str = "";
        str += "Address: " + street + "\n";
        str += "Number of rooms: " + numberOfRooms + "\n";
        str += "Monthly rent: " + monthlyRent + "\n";
        return str;
    }
}
