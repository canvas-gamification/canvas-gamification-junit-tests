package methods.using_methods.hard.q5;

/*
In University your standing is designated by which numeric year you are in. Write a Java Program called Standing that
asks users what year they are in university. Then, write a method called designationCalc that accepts that integer
as an input parameter and returns a string designating the user's standing. If the user is in their first year, they're freshmen,
if the user is in their second year, they're a sophomore, if the user is in their third year, they're a junior,
and if the user is in their fourth year or above, they're a senior. If the user is not one of these options, the year is unknown.

Sample output:
Please enter what year you are in university:
2
Your designation is a sophomore
 */

import java.util.Scanner;
public class Standing
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter what year you are in university:");
        int currYear = input.nextInt();
        System.out.println("Your designation is a " + designationCalc(currYear));
    }
    public static String designationCalc(int a)
    {
        if (a==1)
            return "freshmen";
        else if (a==2)
            return "sophomore";
        else if (a==3)
            return "junior";
        else if (a>=4)
            return "senior";
        else
            return "unknown year";
    }
}
