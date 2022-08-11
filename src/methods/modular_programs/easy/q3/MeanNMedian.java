package methods.modular_programs.easy.q3;

/*
Write a Java Program that takes three initialized and declared integer variables and determines the mean and median of
the three variables. Remember that the mean is the average of the three numbers (write a separate to return the average),
and that the median is the middle number when all three numbers are sorted from least to greatest (write a separate
method to complete this).
Sample output:
The average of the three integers is 13.0
The median of the three integers is 5
 */

import java.util.Scanner;
public class MeanNMedian
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first integer: ");
        int a = input.nextInt();
        System.out.println("Enter the second integer: ");
        int b = input.nextInt();
        System.out.println("Enter the third integer: ");
        int c = input.nextInt();
        System.out.println("The average of the three integers is " + averageCalc(a,b,c));
        System.out.println("The median of the three integers is " + medianCalc(a,b,c));
    }
    public static double averageCalc(int a, int b, int c)
    {
        return (a+b+c)/3.0;
    }
    public static int medianCalc(int a, int b, int c)
    {
        if ((a < b && b < c) || (c < b && b < a))
            return b;
        else if ((b < a && a < c) || (c < a && a < b))
            return a;
        else
            return c;
    }
}

