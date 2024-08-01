package oop.programs_with_interesting_classes.medium.q7;

public class HotSoup {
    private double price;
    private String flavour;

    public HotSoup(double p, String f) {
        price = p;
        flavour = f;
    }

    public double getPrice() {
        return price;
    }

    public String getFlavour() {
        return flavour;
    }

    public String toString() {
        return flavour + " soup for $" + price;
    }
}
