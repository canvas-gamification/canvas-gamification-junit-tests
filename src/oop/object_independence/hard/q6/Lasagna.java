package oop.object_independence.hard.q6;

public class Lasagna {
    private boolean isBad;
    private boolean inGarbage;
    private double hoursSinceMade;

    public Lasagna(boolean b, boolean t, double w) {
        isBad = b;
        inGarbage = t;
        hoursSinceMade = w;
    }

    public void gettingOld() {
        isBad = true;
    }

    public void throwFood() {
        inGarbage = true;
    }

    public boolean getIsBad() {
        return isBad;
    }

    public boolean getInGarbage() {
        return inGarbage;
    }

    public double getHoursSinceMade() {
        return hoursSinceMade;
    }

    public String toString() {
        return "The dish was made " + hoursSinceMade + " hours ago. Is it bad? " + isBad + ". Has it been thrown out? " + inGarbage + ".";
    }
}

