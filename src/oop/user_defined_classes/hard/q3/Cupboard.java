package oop.user_defined_classes.hard.q3;

public class Cupboard
{
    private int pots;
    private boolean allClean;
    public Cupboard()
    {
        pots = 0;
        allClean = false;
    }
    public void washComplete(int a)
    {
        pots = pots + a;
        if (!allClean)
            allClean = true;
    }
}

