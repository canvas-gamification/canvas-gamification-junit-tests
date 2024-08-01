package oop.programs_with_interesting_classes.medium.q8;

public class Food {
    private String name;
    private int daysToExpiration;

    public Food(String s, int d) {
        name = s;
        daysToExpiration = d;
    }

    public String getName() {
        return name;
    }

    public int getDaysToExpiration() {
        return daysToExpiration;
    }

    public void increaseExpirationLength() {
        daysToExpiration++;
    }

    public void decreaseExpirationLength() {
        daysToExpiration--;
    }

    public String toString() {
        return name + " will expire in " + daysToExpiration + " days";
    }
}
