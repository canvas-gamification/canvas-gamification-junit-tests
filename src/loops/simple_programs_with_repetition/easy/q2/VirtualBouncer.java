package loops.simple_programs_with_repetition.easy.q2;

/*
Write a program that asks the user to enter either 1, 2, 3 , or 4, and keep asking them to enter a valid value
until they enter one of these 4 values.

Sample output:
Enter either 1, 2, 3, 4:
7
Please only enter either 1, 2, 3, or 4:
1
You entered a valid number!
 */

import java.util.Scanner;
public class VirtualBouncer
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter either 1, 2, 3, 4: " );
        int n = input.nextInt();
        while( n != 1 && n != 2 && n != 3 && n != 4 )
        {
            System.out.println( "Please only enter either 1, 2, 3, or 4: ");
            n = input.nextInt();
        }
        System.out.println( "You entered a valid number!" );
    }
}

