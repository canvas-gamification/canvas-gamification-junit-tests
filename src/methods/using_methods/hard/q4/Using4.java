package methods.using_methods.hard.q4;

/*
Write a Java Program that asks users for the current year and for the year that they were born in.
Then, write a method that accepts both values as input parameters and returns the age of the user.
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
