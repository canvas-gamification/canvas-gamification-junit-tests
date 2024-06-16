package oop.special_class_method.hard.q14;

public class Bottle {
    private boolean isFull;

    public Bottle() {
        isFull = false;
    }

    public String toString() {
        String str = "I am ";
        if (isFull)
            str += "full";
        else
            str += "empty";
        return str;
    }

    public void setIsFull(boolean a) {
        isFull = a;
    }

    public boolean getIsFull() {
        return isFull;
    }
}
