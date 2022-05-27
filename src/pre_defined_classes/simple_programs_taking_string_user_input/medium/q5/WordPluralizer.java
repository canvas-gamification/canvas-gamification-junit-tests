package pre_defined_classes.simple_programs_taking_string_user_input.medium.q5;
/*
In English, the plural form of a noun often ends in s or es. Make a program that takes a word from the user and prints
out these common plural forms of that word. Assume the user provides valid input.
Sample Output:
	Enter a word: boot
	The plural form may be boots or bootes.

 */

import java.util.Scanner;

public class WordPluralizer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = input.next();
        System.out.println("The plural form may be " + word + "s" + " or " + word + "es.");
    }
}
