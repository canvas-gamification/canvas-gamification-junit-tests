package methods.modular_programs.easy.q4;

/*
Write a Java Program that takes three double variables from the user, then write a method to return the number values
after the decimal point. (e.g. if the double number is 14.5673, return 0.5673). If the variables are negative, return
the negative decimal values.
Sample output:
Enter the first number:
34.123
Enter the second number:
54.24
Enter the third number:
1.39264
The values after the decimal point for the first variable are 0.12299999999999756
The values after the decimal point for the second variable are 0.240000000000002
The values after the decimal point for the third variable are 0.3926400000000001
 */

import java.util.Scanner;
public class ReturnChange
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double a = input.nextDouble();
        System.out.println("Enter the second number: ");
        double b = input.nextDouble();
        System.out.println("Enter the third number: ");
        double c = input.nextDouble();
        System.out.println("The values after the decimal point for the first variable are " + valueAfterCalc(a));
        System.out.println("The values after the decimal point for the second variable are " + valueAfterCalc(b));
        System.out.println("The values after the decimal point for the third variable are " + valueAfterCalc(c));
    }
    public static double valueAfterCalc(double a)
    {
        if(a < 0)
            return (a - Math.ceil(a));
        else
            return a - Math.floor(a);
    }
}

