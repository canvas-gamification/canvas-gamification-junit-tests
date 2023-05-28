package oop.object_interactions.hard.q3;

public class TestBlood {
    public static void main(String[] args) {
        BloodDonor person1 = new BloodDonor("Jill", "A");
        BloodDonor person2 = new BloodDonor("Jane", "B");
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        if (person1.canReceiveBloodFrom(person2))
            System.out.println("They are compatible");
        else
            System.out.println("They are incompatible");
    }
}
