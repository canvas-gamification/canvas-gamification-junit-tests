package loops.for_loops.hard.q8;

import java.util.Scanner;
/*
 * Write a program that asks the user for a sentence and then counts the number of characters in the sentence.
 * (Hint: Space is not considered a character)
 * 
 * Sample Output:
 *    Enter a sentence:
 *    Hello World!
 *    Total number of Characters in the sentence: 11
 * 
 */
public class CounterChar {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a sentence:");
    String sentence = input.nextLine();
    int count = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) != ' ')
        count++;
    }
    System.out.println("Total number of characters in the sentence: " + count);
  }
}
