package oop.static_modifier.hard.q3;

public class CandyStore {
    private static int gummies = 100;
    private String name;

    public CandyStore(String n) {
        name = n;
    }

    public void award(int amount) {
        if (gummies >= amount)
            gummies = gummies - amount;
        System.out.println("There are " + gummies + " more to give away after the " + name + " award.");
    }
}

