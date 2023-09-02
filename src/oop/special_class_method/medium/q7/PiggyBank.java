package oop.special_class_method.medium.q7;

public class PiggyBank {
    private int numPennies;
    private int numNickels;

    public PiggyBank() {
        numPennies = 0;
        numNickels = 0;
    }

    public void setNumPennies(int n) {
        numPennies = n;
    }

    public void setNumNickels(int n) {
        numNickels = n;
    }

    public int getNumPennies() {
        return numPennies;
    }

    public int getNumNickels() {
        return numNickels;
    }

    public String toString() {
        String str = "The total amount is $";
        double dollars = (numPennies * 1 + numNickels * 5) / 100.0;
        str += dollars;
        return str;
    }

}
