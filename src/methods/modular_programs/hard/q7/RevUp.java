package methods.modular_programs.hard.q7;

/**
 * [J] Write a Java Program with a method called revString that accepts a string
 * and returns it in reverse. Write a main method that asks the user to enter a
 * sentence and calls the revString method and prints the result.
 * Sample Output:
 *    Enter a sentence: Hello World
 *    Your sentence in reverse is: dlroW olleH
 * 
 */
import java.util.Scanner;

public class RevUp {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a sentence");
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
