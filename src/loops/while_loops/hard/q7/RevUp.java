package loops.while_loops.hard.q7;
/*
Write a program that will ask the user for a sentence and prints the sentence in reverse using a while loop.
 */

import java.util.Scanner;

public class RevUp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = input.nextLine();
        String result = "";
        int i = sentence.length() - 1;
        while (i >= 0) {
            result += sentence.charAt(i);
            i--;
        }
        System.out.println("Reversed Sentence: " + result);
    }
}
