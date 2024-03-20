package oop.object_interactions.medium.q4;

public class Snail {
    private char bloodType;
    private double volume;

    public Snail(char type, double vol) {
        bloodType = type;
        volume = vol;
    }

    public void transfusionFrom(Snail donor) {
        if (bloodType == donor.getBloodType()) {
            System.out.println("Checking if donor has enough blood for a transfusion...");
            if (donor.getVolume() > 5) {
                donor.setVolume(donor.getVolume() - 1);
                volume += 1;
                System.out.println("Blood transfusion completed");
            } else
                System.out.println("Donor does not have enough blood for a transfusion");
        } else
            System.out.println("Blood type incompatible");
    }

    public char getBloodType() {
        return bloodType;
    }

    public double getVolume() {
        return volume;
    }

    public void setBloodType(char type) {
        bloodType = type;
    }

    public void setVolume(double vol) {
        volume = vol;
    }

    public String toString() {
        return "My blood type is " + bloodType + " and I have " + volume + "L of blood left";
    }
}

