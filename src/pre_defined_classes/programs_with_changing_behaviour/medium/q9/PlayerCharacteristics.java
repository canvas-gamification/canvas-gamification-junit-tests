package pre_defined_classes.programs_with_changing_behaviour.medium.q9;

/*
You are playing a role-playing game (RPG)! You have to select the age and height of your character, but you aren't sure
what values to use for them. Thankfully, this game has a randomizer built-in to obtain the character's age and height.
You want to make sure the age is between 1 and 50 (inclusive of both values), and the height is between 50 and 200
(inclusive of both values). Make a Java Program that performs these functions.

Sample output:
The character age is: 14
The character height is: 73

 */

import java.util.Random;

public class PlayerCharacteristics {
    public static void main( String[] args )
    {
        Random gen = new Random();
        int age = gen.nextInt( 50 ) + 1;
        int height = gen.nextInt( 151 ) + 50;
        System.out.println( "The character age is: " + age );
        System.out.println( "The character height is: " + height );
    }

}
