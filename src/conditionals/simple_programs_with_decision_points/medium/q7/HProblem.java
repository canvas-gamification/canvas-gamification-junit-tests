package conditionals.simple_programs_with_decision_points.medium.q7;
/*
Write a program that asks for the current health points (HP) of the player, and prints out "Not Alive" if the HP less
than or equal to 0, and displays the remaining HP out of 100 if HP is above 0. Assume the user will not input a number
larger than 100.
 */

import java.util.Scanner;
public class HProblem
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("What is your HP right now?");
        double hp = input.nextDouble();
        if( hp <= 0 )
            System.out.println("Not Alive");
        else
            System.out.println("Remaining HP: " + hp + " / 100");
    }
}
