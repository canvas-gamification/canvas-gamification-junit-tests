package methods.modular_programs.easy.q6;

/*
Write a Java Program that asks users for the year that they were born in, then returns what century they were born in.
The program should not accept any year preceding the 1900s as no one from then is still alive.
Sample output:
Please enter the year you were born in:
2002
You're from the 21st Century
 */

import java.util.Scanner;
public class Century
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the year you were born in: ");
        int userYear = input.nextInt();
        System.out.println("You're from the " + centuryCalc(userYear));
    }
    public static String centuryCalc(int userYear)
    {
        if (userYear>=2000)
            return "21st Century";
        else if (userYear>1899)
            return "20th Century";
        else
            return "Invalid user Year";
    }
}
