package oop.programs_with_interesting_classes.hard.q7;

import java.util.Scanner;
public class Globe
{
    public static void main(String[] args)
    {
        Animal a1 = new Animal ("Snake", "Hissss");
        Animal a2 = new Animal ("Panda", "Squeeeak");
        Animal a3 = new Animal ("Lion", "Rooaaar");
        Animal a4 = new Animal ("Cow", "Mooooo");
        Animal a5 = new Animal("Cat", "Meowww");
        Animal a6 = new Animal("Crow", "Cawwwww");

        Country c1 = new Country( "India", new Animal[]{a1, a4, a5, a6} );
        Country c2 = new Country( "China", new Animal[]{a1, a2, a5, a6} );
        Country c3 = new Country( "Kenya", new Animal[]{a1, a3, a4, a5, a6} );
        Country c4 = new Country( "USA", new Animal[]{a1, a4, a5, a6} );
        Country[] funGlobe = { c1, c2, c3, c4 };

        Scanner input = new Scanner( System.in );
        System.out.println( "Select one of the following countries:" );
        System.out.println( "India (1)" );
        System.out.println( "China (2)" );
        System.out.println( "Kenya (3)" );
        System.out.println( "USA   (4)" );
        int selection = input.nextInt();
        int index = selection - 1;
        String response = "In " + funGlobe[index].getName() + ", you can hear a ";
        Animal a = funGlobe[index].getRandomAnimal();
        response += a.getName() + " ";
        response += a.getSound() + " ";
        System.out.println( response );
    }
}
