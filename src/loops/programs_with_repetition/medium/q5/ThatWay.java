package loops.programs_with_repetition.medium.q5;

/*
 * Write a program to print the following pattern using nested loops : 
 * 
 * Sample output:
 *    *
 *    * * 
 *    * * * 
 *    * * * * 
 *    * * * * *
 *    * * * *
 *    * * *
 *    * *
 *    *
 */

public class ThatWay {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (int k = 0; k <= i; k++)
        System.out.print("* ");
      System.out.println();
    }
    for (int i = 1; i < 5; i++) {
      for (int k = 0; k < 5 - i; k++)
        System.out.print("* ");
      System.out.println();
    }
  }
}
