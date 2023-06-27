package oop.special_class_method.medium.q6;

public class Scissors {
    private boolean isSharp;
    private boolean outOfReach;

    public Scissors(boolean isp, boolean cct) {
        isSharp = isp;
        outOfReach = cct;
    }

    public boolean getIsSharp() {
        return isSharp;
    }

    public boolean getOutOfReach() {
        return outOfReach;
    }

    public void setIsSharp(boolean a) {
        isSharp = a;
    }

    public void setOutOfReach(boolean a) {
        outOfReach = a;
    }

    public String toString(){
        return "isSharp is " + isSharp + " and outOfReach is " + outOfReach;
    }
}

