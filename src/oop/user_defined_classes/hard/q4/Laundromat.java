package oop.user_defined_classes.hard.q4;

public class Laundromat
{
    private int gymClothes;
    public Laundromat( int n )
    {
        gymClothes = n;
    }
    public void doLaundry()
    {
        int dirtyItems = 0;
        while( dirtyItems <= gymClothes )
        {
            System.out.println( "Cleaning item " + gymClothes );
            dirtyItems++;
        }
        gymClothes = 0;
        System.out.println( "Your laundry is done!" );
    }
}

