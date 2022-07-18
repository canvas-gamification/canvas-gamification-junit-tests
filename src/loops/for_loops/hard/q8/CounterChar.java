package loops.for_loops.hard.q8;

import java.util.Scanner;

public class CounterChar {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a sentence");
    String sentence = input.nextLine();
    int count = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) != ' ')
        count++;
    }
    System.out.println("Total number of Characters in the sentence: " + count);
  }
}
