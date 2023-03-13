package oop.user_defined_classes.hard.q1;

public class Luggage {
    private int numShirts;
    private int numPants;

    public Luggage(int item1, int item2) {
        numShirts = item1;
        numPants = item2;
    }

    public int sumItems() {
        return numShirts + numPants;
    }
}
