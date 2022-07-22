package loops.nested_loops.hard.q7;

/*
Write a program called BoxMeNow to ask the user for an n, and print the following pattern using nested loops,
with the n being the side length of the box (the number of 1’s per side). If the input is less than zero print “Invalid input!”.

Enter number of lines:
4
1 1 1 1
1     1
1     1
1 1 1 1

 */

import java.util.Scanner;
public class BoxMeNow
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter number of lines: ");
        int n = input.nextInt();
        if(n < 0)
            System.out.println("Invalid input!");
        else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((i == 1 || i == n) || (j == 1 || j == n))
                        System.out.print("1 ");
                    else
                        System.out.print("  ");
                }
                System.out.println();
            }
        }
    }
}

