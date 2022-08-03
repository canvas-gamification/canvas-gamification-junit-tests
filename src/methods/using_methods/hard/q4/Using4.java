package methods.using_methods.hard.q4;

/*
Write a Java Program called Using4 that asks users for the current year and for the year that they were born in.
Then, write a method called ageCalc that accepts both values as input parameters and returns the age of the user.

Sample output:
Please enter the current year:
2022
Please enter the year you were born in
1998
Your age is 24
 */

import java.util.Scanner;
public class Using4
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
        return a-b;
    }
}
