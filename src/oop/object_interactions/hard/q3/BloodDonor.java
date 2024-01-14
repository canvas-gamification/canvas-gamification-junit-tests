package oop.object_interactions.hard.q3;

public class BloodDonor {
    private String name;
    private String bloodType;

    public BloodDonor(String name, String bloodType) {
        this.name = name;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String toString() {
        return name + "'s blood type is " + bloodType;
    }

    public boolean canReceiveBloodFrom(BloodDonor donor) {
        String donorType = donor.getBloodType();
        String receiverType = this.getBloodType();
        if (donorType.equals("A")) {
            return receiverType.equals("A") || receiverType.equals("AB");
        } else if (donorType.equals("B")) {
            return receiverType.equals("B") || receiverType.equals("AB");
        } else if (donorType.equals("AB")) {
            return receiverType.equals("AB");
        } else {
            return receiverType.equals("O") || receiverType.equals("A") || receiverType.equals("B") || receiverType.equals("AB");
        }
    }
}
