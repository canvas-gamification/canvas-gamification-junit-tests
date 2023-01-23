package methods.modular_programs.hard.q7;

/*
Write a Java Program that asks the user to enter a sentence and calls a method called revString. The method accepts the
string and returns it in reverse, which the main method then prints.

Sample Output:
    Enter a sentence:
    Hello World
    Your sentence in reverse is: dlroW olleH
 */

import java.util.Scanner;

public class RevUp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = input.nextLine();
        String result = revString(sentence);
        System.out.println("Your sentence in reverse is: " + result);
    }

    public static String revString(String sentence) {
        String result = "";
        for (int i = sentence.length() - 1; i >= 0; i--)
            result += sentence.charAt(i);
        return (result);
    }
}
