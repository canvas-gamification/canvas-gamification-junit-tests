package methods.defining_methods.medium.q5;

/*
Write a program that takes a boolean variable and inverts the value (if the value is true, make it false, and vice.
versa.). Then, create a method called inverseCalc that accepts a boolean variable and inverts it, returning that value.
The inverted value should be printed by your program.

Sample output:
    Enter a boolean:
    false
    The inverse value of the given boolean variable is: true

 */

import java.util.Scanner;

public class InverseMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a boolean: ");
        boolean b = in.nextBoolean();
        System.out.println("The inverse value of the given boolean variable is: " + inverseCalc(b));
    }

    public static boolean inverseCalc(boolean a) {
        if (!a)
            return true;
        else
            return false;
    }
}
