package loops.programs_with_repetition.hard.q4;

/*
Write a program that accepts a sentence from the user and prints the sentence after reversing every other word,
starting from the first word, using nested loops. Assume that every word is separated by a single space " ",
and there are no consecutive spaces.
 */

import java.util.Scanner;

public class ArtificialSelection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sen = " " + input.nextLine();
        int spaceCount = 0;
        for (int i = 0; i < sen.length(); i++) {
            int nextSp = sen.indexOf(' ', i + 1);
            if (nextSp == -1)
                nextSp = sen.length();
            if (sen.charAt(i) == ' ' && i != sen.length() - 1) {
                spaceCount++;
                String word = sen.substring(i + 1, nextSp);
                if (spaceCount % 2 == 1)
                    for (int j = word.length() - 1; j >= 0; j--)
                        System.out.print(word.charAt(j));
                else
                    for (int j = 0; j < word.length(); j++)
                        System.out.print(word.charAt(j));
                System.out.print(" ");
            }
        }
    }
}
