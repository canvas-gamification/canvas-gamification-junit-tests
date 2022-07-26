package pre_defined_classes.simple_programs_taking_string_user_input.medium.q1;
/*
Make a program that asks the user for a name and age, and then displays a greeting message using the inputted values.
Assume the user only provides valid input.

Sample Output:
    What's your name?
    John Doe
    How old are you?
    45
    Hi John Doe, you are 45 years old!
 */

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = input.nextLine();
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("Hi " + name + ", you are " + age + " years old!");
    }
}
