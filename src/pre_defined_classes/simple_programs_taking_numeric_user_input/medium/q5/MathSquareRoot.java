package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q5;
/*
A math teacher is looking to create a program to teach her students about square roots. Make a program that asks a user
for a number and displays its square root. Assume the user enters only enters integers greater than or equal to 0
(non-negative integers).
Sample Output:
	Enter a number: 4
	The square root of 4 is 2

 */

import java.util.Scanner;

public class MathSquareRoot {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        System.out.print("The square root of " + num + " is " + (Math.sqrt(num)));
    }

}
