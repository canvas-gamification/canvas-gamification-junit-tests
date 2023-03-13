package oop.user_defined_classes.hard.q1;

public class Luggage {
    private int numShirts;
    private int numPants;

    public Luggage(int ns, int np) {
        numShirts = ns;
        numPants = np;
    }

    public int sumItems() {
        return numShirts + numPants;
    }
}
