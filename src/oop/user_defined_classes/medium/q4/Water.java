package oop.user_defined_classes.medium.q4;

public class Water
{
    private double volume;
    private String quality;
    public Water( double amount, String level )
    {
        if(amount > 0)
            volume = amount;
        else
            volume = 0;
        quality = level;
    }
}
