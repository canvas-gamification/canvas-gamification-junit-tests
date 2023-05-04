package oop.user_defined_classes.medium.q3;

public class Horse {
    private double weight;

    public Horse(double wt) {
        if(wt > 0)
            weight = wt;
        else
            weight = 0;
    }

    public String makeSound() {
        return "Neigh!!";
    }
}
