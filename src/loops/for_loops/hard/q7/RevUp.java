package loops.for_loops.hard.q7;

/*
 * Write a program that will ask the user for a sentence and prints the sentence in reverse. 
 * Sample output:
 *    Enter a sentence: 
 *    Hello World
 *    dlroW olleH
 * 
 */

import java.util.Scanner;

public class RevUp {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a sentence: ");
    String sentence = input.nextLine();
    String result = "";
    for (int i = sentence.length() - 1; i >= 0; i--)
      result += sentence.charAt(i);
    System.out.println("Reversed Sentence: " + result);
  }
}
