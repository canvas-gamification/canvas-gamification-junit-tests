package oop.user_defined_classes.hard.q3;

public class Cupboard
{
    private int pots;
    private boolean anyClean;
    public Cupboard()
    {
        pots = 0;
        anyClean = false;
    }
    public void washComplete(int a)
    {
        pots = pots + a;
        if (pots > 0)
            anyClean = true;
    }
}
