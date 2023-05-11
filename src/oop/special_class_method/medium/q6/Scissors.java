package oop.special_class_method.medium.q6;

public class Scissors {
    private boolean isSharp;
    private boolean canCut;

    public Scissors(boolean isp, boolean cct) {
        isSharp = isp;
        canCut = cct;
        ;
    }

    public boolean getIsSharp() {
        return isSharp;
    }

    public boolean getCanCut() {
        return canCut;
    }

    public void setIsSharp(boolean a) {
        isSharp = a;
    }

    public void setCanCut(boolean a) {
        canCut = a;
    }

    public String toString(){
        return "isSharp is " + isSharp + " and canCut is " + canCut;
    }
}

