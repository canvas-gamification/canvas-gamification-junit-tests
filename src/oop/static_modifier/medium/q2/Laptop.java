package oop.static_modifier.medium.q2;

/*
public static int incrementeer()
{
}
initial
private static double initial = 10;
public int getIdentification( int a )
public void setIdentification()
private static int incrementer( int a )
 */

public class Laptop
{
    private int identification;
    private static int initial = 0;
    public Laptop()
    {
        identification = incrementer();
    }
    private static int incrementer()
    {
        initial = initial + 5;
        return initial;
    }
    public void setIdentification( int a ) {
        identification = a;
    }
    public int getIdentification() {
        return identification;
    }
}
