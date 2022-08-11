package methods.defining_methods.medium.q5;

/*
Write a Java Program that takes a boolean variable and inverts the value (if the value is true, make it false, and vice. versa.).
Write a Java Method that accepts the boolean variable and returns a boolean value.
Sample output:
Enter a boolean:
false
The inverse value of the given boolean variable is: true

 */

import java.util.Scanner;
public class InverseMethod
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a boolean: ");
        boolean b = in.nextBoolean();
        System.out.println("The inverse value of the given boolean variable is: " + inverseCalc(b));
    }
    public static boolean inverseCalc(boolean a)
    {
        if (!a)
            return true;
        else
            return false;
    }
}
