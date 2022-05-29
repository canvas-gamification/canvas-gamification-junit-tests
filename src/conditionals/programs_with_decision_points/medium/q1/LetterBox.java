package conditionals.programs_with_decision_points.medium.q1;

/*
Write a program that asks the user for a character and checks if it is an uppercase letter, a lowercase letter, or neither.
Assume the user provides valid input.
 */

import java.util.Scanner;

public class LetterBox {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char c = input.next().charAt(0); //Extracts the first character entered by the user
        if (c >= 'a' && c <= 'z')
            System.out.println(c + " is a lowercase letter");
        else if (c >= 'A' && c <= 'Z')
            System.out.println(c + " is an uppercase letter");
        else
            System.out.println(c + " is neither uppercase nor lowercase");
    }
}
