package oop.static_modifier.hard.q6;

public class Farm {
    private static double foodDonation = 50;
    private double amountPerAnimal;
    private int numAnimals;

    public Farm(double amount, int num) {
        amountPerAnimal = amount;
        numAnimals = num;
    }

    public double foodNeeded() {
        return numAnimals * amountPerAnimal;
    }

    public void receiveDonation() {
        if (foodDonation >= foodNeeded()) {
            foodDonation -= foodNeeded();
            System.out.println("Thank you for your donation.");
        } else {
            System.out.println("Thank you, but there is not enough for everyone here.");
        }
    }
}

