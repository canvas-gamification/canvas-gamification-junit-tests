package oop.programs_with_interesting_classes.medium.q3;

public class Pokemon {
    private final int BASE = 1;
    private final int INTERMEDIATE = 2;
    private final int ADVANCED = 3;
    private String type;
    private String name;
    private int health;
    private int experienceLevel;
    private int evolveLevel;

    public Pokemon(String n, String t, int d )
    {
        experienceLevel = d;
        type = t;
        name = n;
        evolveLevel = BASE;
        health = 100;
    }
    public void attack( Pokemon p )
    {
        int myPower = (int) Math.floor( health / 10.0 );
        p.setHealth( p.getHealth() - myPower );
        if( myPower > 10 )
            System.out.println( "That attack was very effective!" );
        else
            System.out.println( "That attack wasn't very effective!" );
        health--;
        battleExp((int) Math.floor( myPower/2.0 ));
    }
    private void battleExp( int d )
    {
        experienceLevel = experienceLevel + d;
        this.checkEvolution();
    }
    private void checkEvolution()
    {
        if ( experienceLevel < 16 )
            evolveLevel = BASE;
        else if (experienceLevel <= 32)
            evolveLevel = INTERMEDIATE;
        else
            evolveLevel = ADVANCED;
    }
    public String toString()
    {
        return name + " is a " + type + " type creature with " + experienceLevel + " experience and has evolved to " + evolveLevel;
    }
    public int getHealth(){ return health; }
    public void setHealth(int health){this.health = health;}
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
