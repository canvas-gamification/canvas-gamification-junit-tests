package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q4;
/*
Make a program that calculates a user's age based on the current year and their year of birth. Assume the user enters a
valid AD year (integers greater than or equal to 0) and that the current year is greater than the birth year.

Sample Output:
	What is the current year?
	2022
	What year were you born in?
	2002
	You are 20 years old this year!
 */

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the current year?");
        int current = input.nextInt();
        System.out.println("What year were you born in?");
        int yearBirth = input.nextInt();
        int age = current - yearBirth;
        System.out.println("You are " + age + " years old this year!");
    }
}
