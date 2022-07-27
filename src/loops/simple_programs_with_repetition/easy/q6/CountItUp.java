package loops.simple_programs_with_repetition.easy.q6;

/*
Write a program that will ask the user for a sentence and then a character 
and prints out the number of times the entered character occurs in the user's sentence. 
Assume the input is a sentence and a character in lowercase.
*/

import java.util.Scanner;

public class CountItUp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sent = input.nextLine();
        sent.toLowerCase();
        System.out.println("Enter the character to count: ");
        char c = (char) (input.next().charAt(0));
        int count = 0;
        for (int i = 0; i < sent.length(); i++)
            if (sent.charAt(i) == c)
                count++;
        System.out.println("The number of times " + c + " occurs in the sentence is "
        + count + " times.");
    }
}
