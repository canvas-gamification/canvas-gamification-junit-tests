package pre_defined_classes.simple_programs_taking_string_user_input.hard.q1;
/*
Make a program to check if an inputted string is all lower-case. The program should print out true or false if the given
string is all lower case or not.

Sample Output:
	Enter a string:
	It's a dangerous business, Frodo, going out your door. You step onto the road, and if you don't keep your feet,
	there's no knowing where you might be swept off to.
	Is the given string already all lowercase? false

Distractors:
    String check = answer.toUpperCase();
    System.out.println( "Is the given string already all lowercase? " + check );
    System.out.println( "Is the given string already all lowercase? " + answer );
    String answer = input.nextInt();
    String answer = input.nextDouble();
    result = answer.equal( check );
    String check, answer, result;
    String result = answer.equals( check );

 */

import java.util.Scanner;

public class UpperOrLower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String answer = input.nextLine();
        String check = answer.toLowerCase();
        boolean result = answer.equals(check);
        System.out.println("Is the given string already all lowercase? " + result);
    }
}
