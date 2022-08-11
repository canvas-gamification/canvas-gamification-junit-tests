package loops.nested_loops.hard.q6;

/*
Write a program to ask the user for an n ("Enter number of lines: "), and print the following pyramid pattern using
nested loops based on their input:
           1
          212
         32123
        4321234
       543212345
         … 1 ...
n …   ...  1 … …  n
If a negative integer is input print "Invalid input!".

Sample output:
Enter number of lines:
3
   1
  212
 32123
 */

import java.util.Scanner;
public class TryAngleButBothWaysAKAPyramid
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
                for (int j = n - i; j >= 1; j--)
                    System.out.print(" ");
                for (int k = i; k >= 1; k--)
                    System.out.print(k);
                for (int l = 2; l <= i; l++)
                    System.out.print(l);
                System.out.println();
            }
        }
    }
}
