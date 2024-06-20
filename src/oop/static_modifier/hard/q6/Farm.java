package oop.static_modifier.hard.q6;

public class Farm {
    private static double foodInSilo = 50;
    private double amountPerAnimal;
    private int numAnimals;

    public Farm(double amount, int num) {
        amountPerAnimal = amount;
        numAnimals = num;
    }

    public double foodNeeded() {
        return numAnimals * amountPerAnimal;
    }

    public boolean feedAnimals() {
        if (foodInSilo >= foodNeeded()) {
            foodInSilo -= foodNeeded();
            System.out.println("Animals fed and happy");
            return true;
        } else {
            System.out.println("We need to buy more food");
            return false;
        }
    }
}

