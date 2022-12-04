package methods.modular_programs.hard.q8;

/*
Write a program with a method called charCounter that asks the user for a sentence and then counts the number of
characters in the sentence. (Hint: Space / ' ' is not considered a character)

Sample Output:
  Enter a sentence
  Hello World
  Total number of Characters in the sentence: 10

 */

import java.util.Scanner;

public class CounterChar {
    // Java
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = input.nextLine();
        int count = charCounter(sentence);
        System.out.println("Total number of Characters in the sentence: " + count);
    }

    public static int charCounter(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}
