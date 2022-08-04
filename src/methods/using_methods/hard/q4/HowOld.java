package methods.using_methods.hard.q4;

/*
Write a Java Program called HowOld that asks users for the current year and for the year that they were born in.
Then, write a method called ageCalc that accepts both values as input parameters, checks that both years are positive
 and that the current year is greater than or equal to the year the user was born and returns the age of the user.
 If not, return -1.

Sample output:
Please enter the current year:
2022
Please enter the year you were born in
1998
Your age is 24
 */

import java.util.Scanner;
public class HowOld
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the current year:");
        int currYear = input.nextInt();
        System.out.println("Please enter the year you were born in:");
        int yearBorn = input.nextInt();
        System.out.println("Your age is " + ageCalc(currYear,yearBorn));
    }
    public static int ageCalc(int a, int b)
    {
        if(a < 0 || b < 0)
            return -1;
        else if(a < b)
            return -1;
        else
            return a-b;
    }
}
