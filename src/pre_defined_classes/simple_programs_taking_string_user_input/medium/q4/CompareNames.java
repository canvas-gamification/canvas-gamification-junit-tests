package pre_defined_classes.simple_programs_taking_string_user_input.medium.q4;
/*
Make a program that takes in a user's first and last name and compares their length. Display the length of the first
name and last name, respectively. Assume the user provides valid input.

Sample Output:
	What is your full name?
	Bob Ross
	Your first name has 3 characters and your last name has 4 characters.

 */

import java.util.Scanner;

public class CompareNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName, lastName;
        System.out.println("What is your full name? ");
        firstName = input.next();
        lastName = input.next();
        System.out.println("Your first name has " + firstName.length() + " characters and your last name has " + lastName.length() + " characters. ");
    }
}
