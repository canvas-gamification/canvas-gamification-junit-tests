package oop.programs_with_interesting_classes.medium.q3;

public class TestPokemon {
    public static void main( String[] args )
    {
        Pokemon p1 = new Pokemon( "Squirtle", "Water", 5);
        Pokemon p2 = new Pokemon( "Charmander", "Fire", 6);
        System.out.println( "The battle begins!" );
        p1.attack( p2 );
        p2.attack( p1 );
        System.out.println( "The battle has ended!" );
        System.out.println(p1);
        System.out.println(p2);
    }
}
