package oop.special_class_method.hard.q9;

public class Earth {
    private double landMass;
    private int population;

    public Earth(double lm, int p) {
        landMass = lm;
        population = p;
    }

    public void setLandMass(double a) {
        landMass = a;
    }

    public double getLandMass() {
        return landMass;
    }

    public void setPopulation(int a) {
        population = a;
    }

    public int getPopulation() {
        return population;
    }
}
