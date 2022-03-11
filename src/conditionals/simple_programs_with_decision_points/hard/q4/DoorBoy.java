package conditionals.simple_programs_with_decision_points.hard.q4;

/*
Write a program to open the door if it is closed, and close the door if it is open.
(Hint: Use a boolean value to determine the state of the door, such as true for "open" and false for "closed")

Distractors:
if( door != true )
if (door = true)
if( door );
else( !door )
else( !door );
 */
import java.util.Scanner;
public class DoorBoy
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Is the door open or closed right now? (Enter true for open and false for closed)");
        boolean door = input.nextBoolean();
        if( door )
            System.out.println("I will close the door");
        else
            System.out.println("Time to open the door");
    }
}
