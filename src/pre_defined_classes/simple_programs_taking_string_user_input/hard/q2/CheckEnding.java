package pre_defined_classes.simple_programs_taking_string_user_input.hard.q2;
/*
Make a Java program that asks two questions and checks if your first answer ends with the contents of your second
answer. The result of the match is displayed as an answer of either true or false to the question of if the first
string ends with the second string. Assume the user enters valid input.

Sample Output:
    What is the name of your favourite band?
    Imagine Dragons
    What is your favourite word?
    Dragons
    Does the band end with your favourite word? true

Distractions:
    Scanner input = new Scanner();
    System.out.println( What is the name of your favourite band? );
    String band = input.next();
    char endString = input.nextLine();
    System.out.println( "Your band ends with ", endString );
    System.out.println( "Your band does not end with ", endString );

 */

import java.util.Scanner;

public class CheckEnding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String band, endString;
        System.out.println("What is the name of your favourite band?");
        band = input.nextLine();
        System.out.println("What is your favourite word?");
        endString = input.nextLine();
        boolean match = band.endsWith(endString);
        System.out.println("Does the band end with your favourite word? " + match);
    }
}
