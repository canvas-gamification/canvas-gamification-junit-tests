package oop.object_independence.medium.q2;

public class PhoneWaitList {
    private int numAhead;

    public PhoneWaitList(int num) {
        numAhead = num;
    }

    public void setNumAhead(int num) {
        numAhead = num;
    }

    public int getNumAhead() {
        return numAhead;
    }

    public String toString() {
        return "There are " + numAhead + " people ahead of you";
    }
}

